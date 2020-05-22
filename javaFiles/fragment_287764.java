import com.pasindu.queue.seda.queue.Queue;
import com.pasindu.queue.seda.stage.Stage;
import event.BufferEvent;
import monitor.QueueMonitor;
import monitor.ThreadMonitor;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class HttpEventMain extends Thread
{
    private InetAddress addr;
    private int port;
    private Selector selector;
    private ConcurrentHashMap concurrentHashMapResponse;
    private ConcurrentHashMap concurrentHashMapKey;

    public HttpEventMain(InetAddress addr, int port) throws IOException {
        this.setAddr(addr);
        this.setPort(port);
        this.setConcurrentHashMapResponse(new ConcurrentHashMap<>());
        this.concurrentHashMapKey = new ConcurrentHashMap<>();
    }

    @Override
    public void run(){
        System.out.println("----- Running the server on machine with "+Runtime.getRuntime().availableProcessors()+" cores -----");


        try {
            System.out.println("\n====================Server Details====================");
            System.out.println("Server Machine: "+ InetAddress.getLocalHost().getCanonicalHostName());
            System.out.println("Port number: " + this.getPort());

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }

        try {

            this.startServer();

        } catch (IOException e) {
            System.err.println("Error occured in runnable.HttpEventMain:" + e.getMessage());
            System.exit(0);
        }


    }


    public static void main(String[] args) throws Exception
    {
        HttpEventMain server = new HttpEventMain(null, 4333);
        server.start();


    }
    private void startServer() throws IOException {
        this.selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);


        InetSocketAddress listenAddr = new InetSocketAddress(this.addr, this.port);
        serverChannel.socket().bind(listenAddr);
        serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server ready. Ctrl-C to stop.");

        Queue inQueue = new Queue(100, "In Queue");


        Queue outQueue1 = new Queue(100, "Out Queue 1");
        Queue outQueue2 = new Queue(100, "Out Queue 2");
        Queue outQueue3 = new Queue(100, "Out Queue 3");

        int batchSize = 10;

//        Stage stage = new Stage(inQueue, outQueue, batchSize);

        this.setName("Event Main");

        Stage bufferstage = new Stage(inQueue, outQueue1, batchSize);
        bufferstage.setName("bufferstage");
        Stage byteArrayStage = new Stage(outQueue1, outQueue2, batchSize);
        byteArrayStage.setName("byteArrayStage");
        Stage httpRequestStage = new Stage(outQueue2, outQueue3, batchSize);
        httpRequestStage.setName("httpRequestStage");

        ResponseMannager responseMannager = new ResponseMannager(concurrentHashMapResponse, outQueue3);
        responseMannager.setName("responseMannager");

        Thread [] threads = {this, bufferstage, byteArrayStage, httpRequestStage, responseMannager};

        ThreadMonitor monitor = new ThreadMonitor(threads);

        monitor.start();

        Queue [] queues = {inQueue, outQueue1, outQueue2, outQueue3};

        QueueMonitor queueMonitor = new QueueMonitor(queues);

        queueMonitor.start();


        bufferstage.start();
        byteArrayStage.start();
        httpRequestStage.start();

        responseMannager.start();


        while (true) {

            this.selector.select();

            Iterator keys = this.selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = (SelectionKey) keys.next();

                keys.remove();

                if (! key.isValid()) {
                    continue;
                }

                if (key.isAcceptable()) {
                    this.accept(key);
                }
                else if (key.isReadable()) {
                    this.read(key, inQueue);
                }
                else if (key.isWritable()) {
                    this.write(key);
                }
            }
        }

    }

    private void accept(SelectionKey key) throws IOException {

        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel channel = serverChannel.accept();
        channel.configureBlocking(false);


        Socket socket = channel.socket();
        SocketAddress remoteAddr = socket.getRemoteSocketAddress();

        channel.register(this.selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key, Queue inQueue) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(8192);
        int numRead = -1;
        try {
            numRead = channel.read(buffer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (numRead == -1) {

            Socket socket = channel.socket();
            SocketAddress remoteAddr = socket.getRemoteSocketAddress();
            channel.close();
            key.cancel();
            return;

        }

        String requestID = RandomStringUtils.random(32, true, true);
        while(concurrentHashMapKey.containsValue(requestID) || concurrentHashMapResponse.containsKey(requestID)){
            requestID = RandomStringUtils.random(15, true, true);
        }
        concurrentHashMapKey.put(key, requestID);
        try {
            inQueue.enqueu(new BufferEvent(buffer, requestID, numRead));
        }catch (InterruptedException ex){

        }

        concurrentHashMapResponse.put(requestID, false);

        channel.register(this.selector, SelectionKey.OP_WRITE, buffer);
    }

    private boolean responseReady(SelectionKey key){

        String requestId = concurrentHashMapKey.get(key).toString();
        Boolean response = (Boolean) concurrentHashMapResponse.get(requestId);

        if(response==true){
            concurrentHashMapKey.remove(key);
            concurrentHashMapResponse.remove(requestId);
            return true;
        }else{
            return false;
        }

    }

    private void write(SelectionKey key) throws IOException {

        if(responseReady(key)) {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer inputBuffer = (ByteBuffer) key.attachment();
            inputBuffer.flip();
            channel.write(inputBuffer);
            channel.close();
            key.cancel();
        }else{
        }

    }


    public ConcurrentHashMap getConcurrentHashMapResponse() {
        return concurrentHashMapResponse;
    }

    public void setConcurrentHashMapResponse(ConcurrentHashMap concurrentHashMapResponse) {
        this.concurrentHashMapResponse = concurrentHashMapResponse;
    }

    public InetAddress getAddr() {
        return addr;
    }

    public void setAddr(InetAddress addr) {
        this.addr = addr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }
}