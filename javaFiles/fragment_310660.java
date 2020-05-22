public class MultiThreadChatClient implements Runnable {

// The client socket
private Socket clientSocket = null;
// The output stream
private PrintStream os = null;
// The input stream
private final BufferedReader br;
private final int clientId;

public MultiThreadChatClient(int clientId, BufferedReader br) {
    super();
    this.clientId = clientId;
    this.br = br;
}

/*
 * Create a thread to read from the server. (non-Javadoc)
 * 
 * @see java.lang.Runnable#run()
 */
public void run() {
    /*
     * Keep on reading from the socket till we receive "Bye" from the
     * server. Once we received that then we want to break.
     */
    String responseLine;
    try {
        while ((responseLine = br.readLine()) != null) {

            System.out.printf("Client #%d received message=%s\n", clientId, responseLine);

            if (responseLine.indexOf("*** Bye") != -1)
                break;
        }
    } catch (IOException e) {
        System.err.println("IOException1234:  " + e);
    }
}
}