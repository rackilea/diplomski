import java.net.*;

public class Test {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(50000);
        while (true) {
            Socket s = ss.accept();
            System.out.println("Local: " + s.getLocalPort() + 
                               "; Remote: " + s.getPort());
        }
    }
}