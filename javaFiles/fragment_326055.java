public class SimpleServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6666);
        Socket socket = server.accept();
        OutputStream output = socket.getOutputStream();

        byte[] bytes = new byte[32*1024]; // 32K
        while (true) {
            output.write(bytes);
        }
    }
}
public class SimpleClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 6666);
        InputStream input = socket.getInputStream();
        long total = 0;
        long start = System.currentTimeMillis();

        byte[] bytes = new byte[32*1024]; // 32K
        for(int i=1;;i++) {
            int read = input.read(bytes);
            if (read < 0) break;
            total += read;
            if (i % 500000 == 0) {
                long cost = System.currentTimeMillis() - start;
                System.out.printf("Read %,d bytes, speed: %,d MB/s%n", total, total/cost/1000);
            }
        }
    }
}