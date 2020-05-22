public class MySSLSocketFactorySupport extends DefaultTcpNetSSLSocketFactorySupport {

    private final int connectTimeout;

    public MySSLSocketFactorySupport(TcpSSLContextSupport sslContextSupport, int connectTimeout) {
        super(sslContextSupport);
        this.connectTimeout = connectTimeout;
    }

    @Override
    public ServerSocketFactory getServerSocketFactory() {
        throw new UnsupportedOperationException("This does not support server sockets");
    }

    @Override
    public SocketFactory getSocketFactory() {
        return new PostilionSocketFactory();
    }

    private class PostilionSocketFactory extends SocketFactory {

        private final SocketFactory delegate = MySSLSocketFactorySupport.super.getSocketFactory();

        @Override
        public Socket createSocket() throws IOException {
            return delegate.createSocket();
        }

        @Override
        public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
            Socket socket = this.delegate.createSocket();
            socket.connect(new InetSocketAddress(host, port), connectTimeout);
            return socket;
        }

        @Override
        public Socket createSocket(InetAddress host, int port) throws IOException {
            Socket socket = this.delegate.createSocket();
            socket.connect(new InetSocketAddress(host, port), connectTimeout);
            return socket;
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
            Socket socket = this.delegate.createSocket();
            socket.bind(new InetSocketAddress(localHost, localPort));
            socket.connect(new InetSocketAddress(host, port), connectTimeout);
            return socket;
        }

        @Override
        public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
            Socket socket = this.delegate.createSocket();
            socket.bind(new InetSocketAddress(localAddress, localPort));
            socket.connect(new InetSocketAddress(address, port), connectTimeout);
            return socket;
        }

    }

}