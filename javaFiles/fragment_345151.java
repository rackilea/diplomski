// Create SSLSocket object that enables TLS version 1.2.
SSLSocketFactory socketFac = context.getSocketFactory();
SSLSocekt sslSocket = (SSLSocekt)socketFac.createSocket("www.example.com", 443);

An SSLContext with "TLSv1" protocol supports TLS versions up to TLS 1.0 (no TLS 1.1 and 1.2).
An SSLContext created with "TLSv1.1" supports versions up to TLS 1.1 (no TLS 1.2).
// Get SSLContext instance that supports TLS versions up to TLS 1.0.
SSLContext context = SSLContext.getInstance("TLSv1");