public class MyServer {
    public static final int PORT = 12345;
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = ServerSocketFactory.getDefault().createServerSocket(PORT);
        Socket s = ss.accept();
        Thread.sleep(5000);
        ss.close();
        s.close();
    }
}

public class MyClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket s = SocketFactory.getDefault().createSocket("localhost", MyServer.PORT);
        System.out.println(" connected: " + s.isConnected());
        Thread.sleep(10000);
        System.out.println(" connected: " + s.isConnected());
    }
}