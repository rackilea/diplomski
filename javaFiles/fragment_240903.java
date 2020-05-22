import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketTest {
    public static class Client implements Runnable {

        private final BufferedReader in;
        private final PrintWriter out;

        public Client(Socket clientSocket) throws IOException {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );
        }

        public void run() {
            send("Hello");
            String inputLine1 = null, outputLine;
            try {
                while( (inputLine1 = in.readLine()) != null) {
                    outputLine = inputLine1.toLowerCase();
                    System.out.println(inputLine1);
                    send(outputLine);
                    if(outputLine.contentEquals("bye"))
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public synchronized void send(String message) {
            out.println(message);
            out.flush();
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket s = new ServerSocket(5050);
        Socket clientSocket = s.accept();
        Client client = new Client(clientSocket);
        Thread clientThread = new Thread(client);
        clientThread.start();
        int i = 1;
        while (true) {
            Thread.sleep(1000);
            client.send("Tick " + (i++));
        }
    }

}