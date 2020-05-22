public class MySSLSocketFactory extends SSLSocketFactory {

    private SSLContext sslContext = SSLContext.getInstance(Const.Ssl.PROTOCOL_SSL);


    public MySSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        this.sslContext.init(
                null,
                new TrustManager[] { new MyTrustManager(false) },
                new SecureRandom());
    }


    @Override
    public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
            throws IOException {
        socket.connect(new InetSocketAddress(host, port), Const.Ssl.CONNECT_TIMEOUT);
        socket.setSoTimeout(Const.Ssl.DATA_TIMEOUT);
        return this.sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
    }


    @Override
    public String[] getDefaultCipherSuites() {
        return this.sslContext.getSocketFactory().getDefaultCipherSuites();
    }


    @Override
    public String[] getSupportedCipherSuites() {
        return this.sslContext.getSocketFactory().getSupportedCipherSuites();
    }


    @Override
    public Socket createSocket(String host, int port)
            throws IOException, UnknownHostException {
        return this.createSocket(new Socket(), host, port, true);
    }


    @Override
    public Socket createSocket(InetAddress address, int port)
            throws IOException {
        return this.createSocket(new Socket(), address.getHostAddress(), port, true);
    }


    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
            throws IOException, UnknownHostException {
        return this.createSocket(new Socket(), host, port, true);
    }


    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort)
            throws IOException {
        return this.createSocket(new Socket(), address.getHostAddress(), port, true);
    }