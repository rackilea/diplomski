import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

/**
 * {@link NIOServer} class is used to create a Non-Blocking TCP server listening
 * on the port specified in the constructor parameter and listens for clients
 * sending data.
 * 
 * @author AchuthaRanga.Chenna
 * 
 */
public class NIOServer implements Runnable {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private InetAddress hostAddress;
    private int port;
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private boolean runServer = true;

    private ConcurrentHashMap<SocketChannel, Long> clients = new ConcurrentHashMap<SocketChannel, Long>();

    /**
     * Constructor to pass the host and port of server.
     * 
     * @param hostAddress
     *            address on which server has to be run.
     * @param port
     *            port of the server.
     **/
    public NIOServer(InetAddress hostAddress, int port) throws IOException {
        this.hostAddress = hostAddress;
        this.port = port;
        this.selector = initSelector();
        IdleSocketChecker isc = new IdleSocketChecker();
        new Thread(isc).start();
    }

    /**
     * Method to create a ServerSocket and register to selector with option
     * OP_ACCEPT to accept connections from clients.
     * 
     * @return Selector registered with a serverSocket listening on a port to
     *         accept connections.
     * @throws IOException
     *             on fail to create a selector or bind the server to the
     *             address.
     */

    private Selector initSelector() throws IOException {
        Selector socketSelector = SelectorProvider.provider().openSelector();
        this.serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        InetSocketAddress isa = new InetSocketAddress(this.hostAddress, this.port);
        serverSocketChannel.socket().setReuseAddress(true);
        serverSocketChannel.socket().bind(isa);
        serverSocketChannel.register(socketSelector, SelectionKey.OP_ACCEPT);
        return socketSelector;
    }

    /**
     * Method with a infinite loop to iterate over the selected keys of the
     * selector to know the option interested of the client sockets connected.
     * Loop breaks when on IOException occurs on the selector which is listening
     * for IOOperations of the client.
     **/
    @Override
    public void run() {
        while (runServer) {
            try {
                /*
                 * ".select" is a blocking call which invokes when any channel
                 * registered with the selector has an I/O operation to be done.
                 */
                this.selector.select();
                /*
                 * Get a Iterator of the channels having I/O event to be
                 * handled.
                 */
                Iterator<SelectionKey> selectedKeys = this.selector.selectedKeys().iterator();
                /* Iterate over the selected keys having I/O event to be done. */
                while (selectedKeys.hasNext()) {
                    SelectionKey key = (SelectionKey) selectedKeys.next();
                    /* Remove the key to avoid infinite loop. */
                    selectedKeys.remove();
                    try {
                        if (!key.isValid()) {
                            continue;
                        }
                        if (key.isAcceptable()) {
                            this.accept(key);
                        } else if (key.isReadable()) {
                            this.read(key);
                        }
                    } catch (CancelledKeyException e) {// key has been canceled
                    }
                }
                /* Exception is generated when the Selector fails. */
                /*
                 * Close the server and return from the while loop when Selector
                 * fails.
                 */
            } catch (IOException e) {
                logger.error("[run] Exception on generation of client event", e);
                try {
                    serverSocketChannel.close();
                    selector.close();
                } catch (IOException e1) {
                    logger.error("[run] Exception on shutting down NIOSERVER due to selector is closed", e1);
                }
                break;
            }
        }
        logger.info("[NIOSERVER thread closed normally]");
        /* Clean up the resources */
        this.releaseResources();
    }

    /**
     * Method to release the resources used to create NIOSERVER SOCKET.
     */
    public void releaseResources() {
        try {
            this.serverSocketChannel.close();
        } catch (IOException e) {
            logger.warn("[run]", e);
        }
        try {
            this.selector.close();
        } catch (IOException e) {
            logger.warn("[run]", e);
        }
    }

    /**
     * Method to return socket status.
     * 
     * @return
     */
    public boolean isConencted() {
        boolean status = false;
        try {
            status = serverSocketChannel.isOpen();
        } catch (Exception e) {
        }
        return status;
    }

    /**
     * Utility method to stop the server thread.
     * 
     * @param runServer
     *            Flag decides to stop Server
     */
    public void shutDown() {
        this.runServer = false;
        logger.info("[shutDown] Server is stopped");
    }

    /**
     * Method to accept connections from clients and registering for reading
     * data from clients.Set's a KeepAlive option of the socket true and
     * register the connected socket for READ option.
     * 
     * @param key
     *            which is ready to acceptable
     */
    private void accept(SelectionKey key) {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                /* Set the KeepAlive flag to avoid continuous open of files */
                socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
                socketChannel.configureBlocking(false);
                /* Register the client connected with our interested Option Read */
                socketChannel.register(this.selector, SelectionKey.OP_READ);
                // key.attach(System.currentTimeMillis());
                clients.put(socketChannel, System.currentTimeMillis());
                logger.debug("[accept] New Client connected from " + socketChannel.getRemoteAddress());
                logger.info("[accept] Total connected : " + clients.size());
//              System.out.println(socketChannel.hashCode());
            } else {
                key.cancel();
            }
        } catch (IOException e) {
            key.cancel();
            logger.error("[accept] Error while accepting new connectins", e);
        }
    }

    /**
     * * Method to read data from key having read event pending.
     * 
     * @param key
     *            SelectionKey having read event.
     */
    private void read(SelectionKey key) {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        synchronized (socketChannel) {
            if (socketChannel.isOpen()) {
                try {
                    ByteBuffer readBuffer = ByteBuffer.allocate(150);
                    readBuffer.clear();
                    int numRead = 0;
                    try {
                        /* ".read" is nonblocking */
                        numRead = socketChannel.read(readBuffer);
                        /*
                         * Some other IO error on reading socketChannel.
                         */
                    } catch (IOException e) {
                        logger.debug("[run] Connection abruptly terminated from client", e);
                        key.channel().close();
                        clients.remove(socketChannel);
                        return;
                    }
                    if (numRead == -1) {// socket closed cleanly
                        key.channel().close();
                        clients.remove(socketChannel);
                        return;
                    }
                    String data = null;
                    data = new String(readBuffer.array(), Charset.forName("ASCII"));
                    logger.info(data);
                    /* Send the read data to the DataDispatcher Actor */
                    clients.put(socketChannel, System.currentTimeMillis());
                } catch (IOException e) {
                    logger.debug("[run] ", e);
                    return;
                }
            } else {// socketChannel is closed
                try {
                    key.channel().close();// Sanitary close operation
                    clients.remove(key);
                    return;
                } catch (IOException e) {
                }
            }
        }
        logger.info("[checkIdleSockets] Total connected : " + clients.size());
    }

    /**
     * Method to check the sockets idle for 15 minutes and close the socket.
     */
    private void checkIdleSockets() {
//      synchronized (clients) {
            Iterator<Entry<SocketChannel, Long>> iter = clients.entrySet().iterator();
            while (iter.hasNext()) {
                try {
                    Map.Entry<SocketChannel, Long> entry = iter.next();
                    SocketChannel client = entry.getKey();
                    long mills = entry.getValue();
                    double minutes = (System.currentTimeMillis() - mills) / (double) (1000 * 60);
                    if (minutes > 5) {
                        /* key is idle for */
                        logger.info("[IdleSocketChecker] Socket is idle for " + Math.round(minutes) + ", closing......");
                        try {
                            client.close();
                        } catch (IOException e) {
                        } finally {
                            iter.remove();
                        }
                    }
                } catch (Exception e) {
                    logger.info("[IdleSocketChecker] ", e);
                }
            }
//      }
        logger.info("[checkIdleSockets] Total connected : " + clients.size());
    }

    /**
     * {@link IdleSocketChecker} is a thread to check for any idle sockets in
     * the selector.
     * 
     * @author AchuthaRanga.Chenna
     * 
     */
    private class IdleSocketChecker implements Runnable {
        private boolean RUN = true;

        @Override
        public void run() {
            try {
                while (RUN) {
                    /* Wait for 5 Minutes */
                    Thread.sleep(5 * 60 * 1000);
                    checkIdleSockets();
                }
            } catch (InterruptedException e) {
                logger.warn("[IdleSocketChecker]<run> IdleSocketChecker thread stopped", e);
            }
        }
    }
}