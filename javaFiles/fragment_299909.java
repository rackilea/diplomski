import java.net.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception {

    Socket socket = new Socket("localhost", 12345);
    DataInputStream is = new DataInputStream(socket.getInputStream());
    DataOutputStream os = new DataOutputStream(socket.getOutputStream());
    os.writeBytes("Hello \n");
    String line = is.readLine();
    System.out.println("Msg from ruby Server :" + line);
    socket.close();
    }
}