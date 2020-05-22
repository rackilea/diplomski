import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 4444));
        sc.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            selector.select();
            for (SelectionKey key : selector.selectedKeys()) {
                SocketChannel channel = (SocketChannel) key.channel();
                if (key.isConnectable()) {
                    while (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    key.interestOps(SelectionKey.OP_WRITE);
                    System.out.println("Connected");
                }
                if (key.isWritable()) {
                    channel.write(ByteBuffer.wrap(new byte[] { 5 }));
                    key.interestOps(SelectionKey.OP_READ);
                    System.out.println("Sending: 5");
                }
                if (key.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1);
                    channel.read(buffer);
                    System.out.println("Received: " + buffer.array()[0]);
                    key.interestOps(SelectionKey.OP_WRITE);
                }
            }
        }
    }
}