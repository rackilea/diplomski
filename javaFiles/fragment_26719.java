// Server.java
public class Server {

    private ServerSocket        socket;
    private ConnectionListener  connectionListener;

    // temp
    private List<Client> clientList = new ArrayList<Client>();
    // temp end

    public Server(int port) {
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        connectionListener = new ConnectionListener(this);
    }

    public void start() throws IOException {

        connectionListener.start();

        // temp will move to a Thread later
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (((input = stdIn.readLine()) != null) && connectionListener.isAlive()) {
            if (input.equalsIgnoreCase("exit")) {
                break;
            } else {
                for (int i = 0; i < input.length(); i++)
                    System.out.print("\b");
                System.out.println("Admin: " + input);
                for (Client c : clientList) {
                    c.send("Admin: " + input);
                }
            }

        }
        stop();
        // temp end
    }

    public void stop() {

        connectionListener.stop();
        for (Client c : clientList) {
            c.closeSession();
        }

        System.out.println("Server terminated!");
    }

    public synchronized void addConnection(Connection connection) {

        Client c = new Client(connection, clientList);
        clientList.add(c);
        c.startSession();
        System.out.println("Client connected");
    }

    public ServerSocket getSocket() {

        return socket;
    }

    public static void main(String[] args) throws IOException {

        int port;
        if (args.length > 0)
            port = Integer.parseInt(args[0]);
        else
            port = 4444;
        Server s = new Server(port);
        s.start();
    }

}