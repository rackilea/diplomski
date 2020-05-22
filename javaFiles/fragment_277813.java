SSLSocket getSSLSocket(
    File trustStoreFile,
    char[] trustStoreFilePassword,
    InetAddress serverAddress,
    port serverPort
) throws GeneralSecurityException, IOException {
    SSLContext sslContext 
        = SSLConnections.getSSLContext(trustStoreFile, trustStoreFilePassword);
    SSLSocket sslSocket 
        = (SSLSocket) sslContext.getSocketFactory().createSocket
            (serverAddress, serverPort);
    sslSocket.startHandshake();
    return sslSocket;
}