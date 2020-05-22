SSLContext sslContext = new SSLContextBuilder()
        .loadTrustMaterial(null, (x509Certificates, s) -> true)
        .build();

HttpAsyncClientBuilder.create()
        .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
        .setSSLContext(sslContext)
        .build();