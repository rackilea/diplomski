public class ServerStarter {

    private static final ServerStarter singleton = new ServerStarter();

    private volatile boolean shutdown;
    // thread pool executor
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    // observable to notify client threads
    private final Observable observable = new Observable();
    // fair lock (can use unfair lock if message broadcasting order is not important)
    private final Lock fairLock = new ReentrantLock(true);

    private ServerStarter() {
    }

    public static ServerStarter getInstance() {
        return singleton;
    }


    public static void main(String args[]) {
        ServerSocket server = null;
        try {
            //server configs,from left to right is: PORT,BackLog,Address
            server = new ServerSocket();
            while (!ServerStarter.getInstance().isShutdown()) {
                Socket sock = server.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                //each clients run on it's own thread!
                SocketThread clientThread = new SocketThread(sock, inFromClient);
                ServerStarter.getInstance().registerClientThread(clientThread);
                ServerStarter.getInstance().startClientThread(clientThread);
            }
        } catch (IOException e) {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    public void shutdown() {
        shutdown = true;
    }

    public boolean isShutdown() {
        return shutdown;
    }

    public void startClientThread(SocketThread clientThread) {
        executorService.submit(clientThread);
    }

    private void registerClientThread(SocketThread clientThread) {
        observable.addObserver(clientThread);
    }

    public void notifyAllClients(final Object message) {
        fairLock.lock();
        try {
            executorService.submit(new MessageBroadcaster(message));
        } finally {
            fairLock.unlock();
        }
    }

    public void unregisterClientThread(SocketThread clientThread) {
        fairLock.lock();
        try {
            observable.deleteObserver(clientThread);
        } finally {
            fairLock.unlock();
        }
    }

    private class MessageBroadcaster implements Runnable {
        private final Object message;

        public MessageBroadcaster(Object message) {
            this.message = message;
        }

        @Override
        public void run() {
            fairLock.lock();
            try {
                observable.notifyObservers(message);
            } finally {
                fairLock.unlock();
            }
        }
    }
}

class SocketThread implements Runnable, Observer {
    Socket clientSocket;
    BufferedReader inFromClient;

    public SocketThread(Socket clientSocket, BufferedReader inFromClient) {
        this.clientSocket = clientSocket;
        this.inFromClient = inFromClient;
    }

    public void run() {
        try {
            String fromClient;
            while (!ServerStarter.getInstance().isShutdown() && (fromClient = inFromClient.readLine()) != null) {
                // TODO...prepare message to broadcast
                Object message = new Object();
                ServerStarter.getInstance().notifyAllClients(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ServerStarter.getInstance().unregisterClientThread(this);
        }
    }

    @Override
    public void update(Observable o, Object message) {
        // TODO...handle the message
    }
}