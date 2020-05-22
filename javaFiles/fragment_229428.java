class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();
        InputStream i = s.getInputStream();
        i.read();
    }
}