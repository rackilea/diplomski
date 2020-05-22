public class MultiThreadChatServerSync {

// The server socket.
private static ServerSocket serverSocket = null;
// The client socket.
private static Socket clientSocket = null;

// This chat server can accept up to maxClientsCount clients' connections.
private static final int maxClientsCount = 50;
private static final ClientThread[] threads = new ClientThread[maxClientsCount];

public static void main(String args[]) {

    // The default port number.
    int portNumber = 2222;
    if (args.length < 1) {
        System.out.println(
                "Usage: java MultiThreadChatServerSync <portNumber>\n" + "Now using port number=" + portNumber);
    } else {
        portNumber = Integer.valueOf(args[0]).intValue();
    }

    /*
     * Open a server socket on the portNumber (default 2222). Note that we
     * can not choose a port less than 1023 if we are not privileged users
     * (root).
     */
    try {
        serverSocket = new ServerSocket(portNumber);
        // System.out.println(serverSocket.getPort());
    } catch (IOException e) {
        System.out.println(e);
    }

    /*
     * Create a client socket for each connection and pass it to a new
     * client thread.
     */
    while (true) {
        try {
            System.out.println("Awaiting a new connection on "+serverSocket.getLocalPort());
            clientSocket = serverSocket.accept();
            int i = 0;
            for (i = 0; i < maxClientsCount; i++) {
                if (threads[i] == null) {
                    (threads[i] = new ClientThread(i, clientSocket)).start();
                    // System.out.println("A new client is created");
                    break;
                }
            }
            if (i == maxClientsCount) {
                PrintStream os = new PrintStream(clientSocket.getOutputStream());
                os.println("Server too busy. Try later.");
                os.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
}

class ClientThread extends Thread {

private BufferedReader br = null;
private PrintStream os = null;
private final Socket clientSocket;
private final int clientId;

public ClientThread(int clientId, Socket clientSocket) {
    this.clientSocket = clientSocket;
    this.clientId = clientId;
}

public void run() {

    try {
        /*
         * Create input and output streams for this client.
         */
        br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        os = new PrintStream(clientSocket.getOutputStream());

        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.printf("Client <%d> received message=<%s> via Client port: <%d>\n", clientId, line, clientSocket.getPort());
            // Echo it back (as a test)
            os.println(line);
        }
        br.close();
        os.close();
        clientSocket.close();

    } catch (IOException e) {
    }
    System.out.println("Client has closed the session");
}
}