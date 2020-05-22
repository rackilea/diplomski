@Override 
public Socket createSocket(final Socket socket, final String host, final int port, final boolean autoClose) throws IOException, UnknownHostException { 
    SSLSocket sslSocket = (SSLSocket)sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
    sslSocket.setEnabledCipherSuites(newCiphers);
    return sslSocket;

} 

@Override 
public Socket createSocket() throws IOException { 
    SSLSocket sslSocket = (SSLSocket)sslContext.getSocketFactory().createSocket();
    sslSocket.setEnabledCipherSuites(newCiphers);
    return sslSocket;
}