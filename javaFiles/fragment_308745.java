import java.net.DatagramSocket;
import java.net.InetAddress;

try(final DatagramSocket socket = new DatagramSocket()){
  socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
  ip = socket.getLocalAddress().getHostAddress();
}