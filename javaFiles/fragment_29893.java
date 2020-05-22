class MySocketFactory implements SocketFactory {

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress("1.1.1.1", 0));
        socket.connect(new InetSocketAddress(host, port));

        return socket;
    }

    @Override
    public InputStream getInputStream(Socket socket) throws IOException {
        return socket.getInputStream();
    }

    @Override
    public OutputStream getOutputStream(Socket socket) throws IOException {
        return socket.getOutputStream();
    }

}