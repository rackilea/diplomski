import java.net.*;
public class t {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1",8005);
        s.getOutputStream().write("SHUTDOWN".getBytes());
        s.close();
    }
}