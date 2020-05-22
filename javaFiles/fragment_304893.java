import java.net.*;
public class Test {
  public static void main(String[] args) throws Exception {
    Socket socket = new Socket();
    socket.connect(new InetSocketAddress(args[0], 80), 2000);
  }
}