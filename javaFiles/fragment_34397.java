LayeredSocketFactory sf = new LayeredSocketFactory() {

    javax.net.ssl.SSLSocketFactory defaultFactory = HttpsURLConnection.getDefaultSSLSocketFactory();

    @Override
    public Socket createSocket(Socket tcpSocket, String host, int port, boolean autoClose) throws IOException {
        // I'm not actually using impl.createSocket, because then the hostname verifier would have kicked in prior to addMyCipherSuite
        SSLSocket sslSocket = (SSLSocket) defaultFactory.createSocket(tcpSocket, host, port, autoClose);
        impl.getHostnameVerifier().verify(host, addMyCipherSuite(sslSocket));
        return sslSocket;
    }


    @Override
    public Socket createSocket() throws IOException {
        return addMyCipherSuite((SSLSocket) impl.createSocket());
    }

    private Socket addMyCipherSuite(SSLSocket socket) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(socket.getEnabledCipherSuites()));
        list.add("SSL_RSA_WITH_RC4_128_SHA");
        socket.setEnabledCipherSuites(list.toArray(new String[list.size()])); // this is where I add the required cipher suites after the SSLSocket is created
        return socket;
    }

    // unchanged wrappers
    @Override
    public Socket connectSocket(Socket socket, String s, int i, InetAddress inetAddress, int i1, HttpParams httpParams) throws IOException { return impl.connectSocket(socket, s, i, inetAddress, i1, httpParams); }

    @Override
    public boolean isSecure(Socket socket) throws IllegalArgumentException { return impl.isSecure(socket); }
};