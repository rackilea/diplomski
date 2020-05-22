try (SSLSocket sslSocket = (SSLSocket) sslCtx.getSocketFactory().createSocket()) {
        sslSocket.setSoTimeout(5_000);
        Certificate[] certificates = sslSocket.getSession().getPeerCertificates();
        System.out.println(certificates.length);
        sslSocket.connect(new InetSocketAddress("156.70.54.68", 443), 5_000);
    } catch (Exception e) {
        System.out.println(e);
    }