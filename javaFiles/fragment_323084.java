CredentialsProvider credentialsProvider = new BasicCredentialsProvider(); credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

final SSLContext sslContext = SSLContexts.custom()
        .loadTrustMaterial(new File("my_keystore.jks"), keystorePassword.toCharArray(),
            new TrustSelfSignedStrategy())
        .build();


RestClient client = RestClient.builder(new HttpHost(host, port, scheme)).setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
        .setDefaultCredentialsProvider(credentialsProvider)
        .setSSLContext(sslContext)
).build();