interface ServerInterface {
    void newSeverConnection(Socket socket);
}

public class Server implements ServerInterface {

    public Server(int _address) {
        System.out.println("Starting Server...");
        serverConnectionHandler = new ServerConnections(_address, this);
        workers.execute(serverConnectionHandler);
        System.out.println("Do something else...");
    }

    void newServerConnection(Socket socket) {
        System.out.println("A function of my child class was called.");
    }

}

public class ServerConnections implements Runnable {

    private ServerInterface serverInterface;

    public ServerConnections(int _serverPort, ServerInterface _serverInterface) {
      serverPort = _serverPort;
      serverInterface = _serverInterface;
    }

    @Override
    public void run() {
        System.out.println("Starting Server Thread...");

        if (serverInterface == null) {
            System.out.println("Server Thread error: callback null");
        }

        try {
            mainSocket = new ServerSocket(serverPort);

            while (true) {
                serverInterface.newServerConnection(mainSocket.accept());
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}