import java.net.*;

public class Bind {
    public static void main(String... args) throws Exception {
        ServerSocket ss = new ServerSocket(8888, 50, InetAddress.getByName("0.0.0.0"));
        Socket s = ss.accept();
        System.out.println("accepted socket " + s);
    }
}