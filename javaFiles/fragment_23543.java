SSLContext sslContext = new SSLContextBuilder()
        .loadTrustMaterial(null, (x509Certificates, s) -> true)
        .build();

Registry<SchemeIOSessionStrategy> registry = RegistryBuilder.<SchemeIOSessionStrategy>create()
    .register("http", NoopIOSessionStrategy.INSTANCE)
    .register("https", new SSLIOSessionStrategy(sslContext, NoopHostnameVerifier.INSTANCE))
    .build();

DefaultConnectingIOReactor ioReactor = new DefaultConnectingIOReactor();
HttpAsyncClientBuilder.create()
        .setConnectionManager(new PoolingNHttpClientConnectionManager(ioReactor, registry))
        .build();