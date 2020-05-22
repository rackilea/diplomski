/**
 * Returns an SSLServerSocket that uses the specified key store file 
 * with the specified password, and listens on the specified port.
 */
ServerSocket getSSLServerSocket(
    File keyStoreFile, 
    char[] keyStoreFilePassword,
    int port
) throws GeneralSecurityException, IOException {
    SSLContext sslContext 
        = SSLConnections.getSSLContext(keyStoreFile, keyStoreFilePassword);
    SSLServerSocketFactory sslServerSocketFactory 
        = sslContext.getServerSocketFactory();
    SSLServerSocket sslServerSocket
        = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
    return sslServerSocket;
}