public class SocketFileExample {
    static void server() throws IOException {
        ServerSocket ss = new ServerSocket(3434);
        Socket socket = ss.accept();
        InputStream in = new FileInputStream("send.jpg");
        OutputStream out = socket.getOutputStream();
        copy(in, out);
        out.close();
        in.close();
    }

    static void client() throws IOException {
        Socket socket = new Socket("localhost", 3434);
        InputStream in = socket.getInputStream();
        OutputStream out = new FileOutputStream("recv.jpg");
        copy(in, out);
        out.close();
        in.close();
    }

    static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[8192];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread() {
            public void run() {
                try {
                    server();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        client();
    }
}