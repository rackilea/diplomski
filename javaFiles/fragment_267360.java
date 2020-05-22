public class MessageServer {
  Socket sock;
/*Accepts the socket connection and calls the read() method*/
public void go() {
    try {
        @SuppressWarnings("resource")
        ServerSocket socket = new ServerSocket(50000);
        sock = socket.accept();
        read(sock);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
/*Reads the message using InputStreamReader*/
public void read(Socket sock) {
    InputStreamReader stream;
    try {
        stream = new InputStreamReader(sock.getInputStream());
        BufferedReader reader = new BufferedReader(stream);
        System.out.println(reader.readLine());
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
   }

public static void main(String[] args) {
    MessageServer server = new MessageServer();

    server.go();
}}