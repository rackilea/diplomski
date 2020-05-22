public static void main(String[] args) throws IOException {
    ServerSocket svr = new ServerSocket(1234);
    Socket s = svr.accept();
    byte b4[] = new byte[4];
    new DataInputStream(s.getInputStream()).readFully(b4);
    s.getOutputStream().write(b4);
}