HttpClientBuilder builder = HttpClientBuilder.create();
    KeyStore keyStore = initSSL();

    SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(SSLContexts.custom().loadTrustMaterial(keyStore, new
    TrustSelfSignedStrategy()).useTLS().build(), SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

    Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create() 
            .register("http", PlainConnectionSocketFactory.getSocketFactory())
            .register("https", sslConnectionFactory)
            .build();

    PoolingHttpClientConnectionManager ccm = new PoolingHttpClientConnectionManager(registry);
    ccm.setMaxTotal(100);
    ccm.setDefaultMaxPerRoute(5);
    builder.setConnectionManager(ccm);

    BasicCredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(new AuthScope(uri.getHost(), uri.getPort(), name),
            new UsernamePasswordCredentials(username, password));

    builder.setDefaultCredentialsProvider(credsProvider);   

    RequestConfig.Builder requestBuilder = RequestConfig.custom();
    requestBuilder.setSocketTimeout(60000); 
    builder.setDefaultRequestConfig(requestBuilder.build());

    return new HttpContextRequestScopedApacheClientExecutor(builder.build());