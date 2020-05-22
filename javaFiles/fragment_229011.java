static void server() throws IOException {
    ServerSocket ss = new ServerSocket(3434);
    Socket socket = ss.accept();
    OutputStream out = socket.getOutputStream();
    ObjectOutputStream oout = new ObjectOutputStream(out);
    oout.writeObject("your string here");
    oout.close();
}