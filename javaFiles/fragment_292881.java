public class TCPClient {

 public TCPClient(String host, int port) {

        try {
            clientSocket = new Socket(host, port);
        } catch (IOException e) {
            System.out.println(" Could not connect on port: " + port + " to " + host);
        }
}