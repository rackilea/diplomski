import java.net.*;

public class SocketTest {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            args = new String[]{"localhost:80"};
        }
        for (String target: args) {
            test(target);
        }
    }

    private static void test(String target) throws Exception {
        System.out.println("Testing: " + target);
        String[] parts = target.split(":");
        String host = parts[0];
        int port = Integer.valueOf(parts[1]);
        Socket socket = new Socket();
        long start = 0;
        try {
            start = System.nanoTime();
            socket.connect(new InetSocketAddress(host, port), 50);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            long end = System.nanoTime();
            System.out.println("Time: " + ((end - start) / 1000000));
        }
    }
}