public class MultiThreadChatClientRunner {

final int NO_CLIENTS = 5;
//final String HOST_IP = "192.168.2.7";
final String HOST_IP = "localhost";

public static void main(String[] args) {

    new MultiThreadChatClientRunner().start();

}

private void start() {

    Socket[] sockets = new Socket[NO_CLIENTS];
    PrintStream[] writers = new PrintStream[NO_CLIENTS];
    BufferedReader[] readers = new BufferedReader[NO_CLIENTS];

    for (int i = 0; i < NO_CLIENTS; i++) {
        System.out.println("Creating client number "+i);
        Socket clientSocket;
        try {
            clientSocket = new Socket(HOST_IP, 2222);
            writers[i] = new PrintStream(clientSocket.getOutputStream());
            readers[i] = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            new Thread(new MultiThreadChatClient(i, readers[i])).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int clientId = 0;
    Scanner s = new Scanner(System.in);
    while (true) {

        System.out.print("type your message for client #"+clientId);
        String ss = s.nextLine();
        ss = ss.trim().replaceAll(" +", " ");

        writers[clientId].println(ss);
        clientId = (clientId+1)%NO_CLIENTS;

        // Test to broadcast to all clients
        if (clientId == 4) {
            for (int i = 0; i<NO_CLIENTS; i++)
                writers[i].println("Broadcast message: "+ss);
        }

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            break;
        }
    }
    s.close();
}

}