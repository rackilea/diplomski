SSLContext sslContext = SSLContexts.custom()
    .useTLS()
    .build();

SSLConnectionSocketFactory f = new SSLConnectionSocketFactory(
    sslContext,
    new String[]{"TLSv1", "TLSv1.1"},   
    null,
    BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

httpClient = HttpClients.custom()
    .setSSLSocketFactory(f)
    .build();