import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class SocketWrite {

  public static void main(String[] args) throws Exception{

    // create encoder
    CharsetEncoder enc = Charset.forName("US-ASCII").newEncoder();  

    // create socket channel
    ServerSocketChannel srv = ServerSocketChannel.open();

    // bind channel to port 9001   
    srv.socket().bind(new java.net.InetSocketAddress(9001));

    // make connection
    SocketChannel client = srv.accept(); 

    // UNIX line endings
    String response = "Hello!\n";

    // write encoded data to SocketChannel
    client.write(enc.encode(CharBuffer.wrap(response)));

    // close connection
    client.close();
  }
}