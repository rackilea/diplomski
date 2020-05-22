// Set TLS 1.0 only in an SSLParameters object.
sslParameters.setProtocols(new String[] {"TLSv1"});

// Apply the parameters to an SSLSocket object.
sslSocket.setSSLParameters(sslParameters);

// Apply the parameters to an SSLEngine object.
sslEngine.setSSLParameters(sslParameters);