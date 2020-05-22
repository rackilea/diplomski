private SocketChannel createSocketChannel() throws IOException {
        InetSocketAddress socketAddress = new InetSocketAddress(PROXY_ADDRESS, PROXY_PORT);
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(socketAddress);
        socketChannel.configureBlocking(false);
        return socketChannel;

    }

private SSLContext createSSLContext() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sslContext = SSLContext.getInstance(TLS_VERSION);
        sslContext.init(null,null,null);
        return sslContext;
    }




private SSLEngine createSSLEngine() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sslContext = createSSLContext();
        SSLEngine sslEngine = sslContext.createSSLEngine(PROXY_ADDRESS, PROXY_PORT);
        sslEngine.setUseClientMode(true);

        List<SNIServerName> serverNameList = new ArrayList<>();
        serverNameList.add(new SNIHostName(SNI_HOST_NAME));
        SSLParameters sslParameters = sslEngine.getSSLParameters();
        sslParameters.setServerNames(serverNameList);

        sslEngine.setSSLParameters(sslParameters);

        return sslEngine;
    }