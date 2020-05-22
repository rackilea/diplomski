public class EasySSLSocketFactory implements LayeredSocketFactory {

private SSLContext sslcontext = null;

private static SSLContext createEasySSLContext() throws IOException {
    try {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new TrustManager[]{new EasyX509TrustManager(
                null)}, null);
        return context;
    } catch (Exception e) {
        throw new IOException(e.getMessage());
    }
}

private SSLContext getSSLContext() throws IOException {
    if (this.sslcontext == null) {
        this.sslcontext = createEasySSLContext();
    }
    return this.sslcontext;
}

/**
 * @see org.apache.http.conn.scheme.SocketFactory#connectSocket(Socket,
 * String, int, InetAddress, int,
 * HttpParams)
 */
public Socket connectSocket(Socket sock, String host, int port,
                            InetAddress localAddress, int localPort, HttpParams params)
        throws IOException, UnknownHostException, ConnectTimeoutException {
    int connTimeout = HttpConnectionParams.getConnectionTimeout(params);
    int soTimeout = HttpConnectionParams.getSoTimeout(params);

    InetSocketAddress remoteAddress = new InetSocketAddress(host, port);
    SSLSocket sslsock = (SSLSocket) ((sock != null) ? sock : createSocket());

    if ((localAddress != null) || (localPort > 0)) {
        // we need to bind explicitly
        if (localPort < 0) {
            localPort = 0; // indicates "any"
        }
        InetSocketAddress isa = new InetSocketAddress(localAddress,
                localPort);
        sslsock.bind(isa);
    }

    sslsock.connect(remoteAddress, connTimeout);
    sslsock.setSoTimeout(soTimeout);
    return sslsock;

}

/**
 * @see org.apache.http.conn.scheme.SocketFactory#createSocket()
 */
public Socket createSocket() throws IOException {
    return getSSLContext().getSocketFactory().createSocket();
}

/**
 * @see org.apache.http.conn.scheme.SocketFactory#isSecure(Socket)
 */
public boolean isSecure(Socket socket) throws IllegalArgumentException {
    return true;
}

/**
 * @see LayeredSocketFactory#createSocket(Socket,
 * String, int, boolean)
 */
public Socket createSocket(Socket socket, String host, int port,
                           boolean autoClose) throws IOException, UnknownHostException {
    return getSSLContext().getSocketFactory().createSocket(socket, host, port, autoClose);
}

// -------------------------------------------------------------------
// javadoc in org.apache.http.conn.scheme.SocketFactory says :
// Both Object.equals() and Object.hashCode() must be overridden
// for the correct operation of some connection managers
// -------------------------------------------------------------------

public boolean equals(Object obj) {
    return ((obj != null) && obj.getClass().equals(
            EasySSLSocketFactory.class));
}

public int hashCode() {
    return EasySSLSocketFactory.class.hashCode();
}

}