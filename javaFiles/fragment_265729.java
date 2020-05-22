ServerSocketFactory ssf = ServerSocketFactory.getDefault();
ServerSocket serverSocket = ssf.createServerSocket(12345);

// I've initialised an sslContext with a keystore, as you normally would.
Socket socket = serverSocket.accept();
SSLSocketFactory sslSf = sslContext.getSocketFactory();
// The host name doesn't really matter, since we're turning it into a server socket
// (No need to match the host name to the certificate on this side).
SSLSocket sslSocket = (SSLSocket) sslSf.createSocket(socket, null,
    socket.getPort(), false);
sslSocket.setUseClientMode(false);

// Use the sslSocket InputStream/OutputStream as usual.