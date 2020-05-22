SSLSocketFactory ssf = (SSLSocketFactory) sslContext.getSocketFactory();
    SSLSocket sslSocket = (SSLSocket) ssf.createSocket("untrusted.host.example",
            443);
    SSLSession sslSession = sslSocket.getSession();
    // sslSession.getPeerCertificates();
    sslSocket.getInputStream().read();