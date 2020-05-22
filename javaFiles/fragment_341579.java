public RestTemplate getRestTemplate(final String keyStoreFile, final String trustStoreFile,
                                    final String password) throws Exception {

    final SSLContext sslContext = SSLContextBuilder.create()
                                                   .loadKeyMaterial(ResourceUtils.getFile(keyStoreFile), password.toCharArray(), password.toCharArray())
                                                   .loadTrustMaterial(ResourceUtils.getFile(trustStoreFile), password.toCharArray())
                                                   .build();

    final HttpClient client = HttpClients.custom()
                                         .setSSLContext(sslContext)
                                         .build();

    final HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
    httpComponentsClientHttpRequestFactory.setHttpClient(client);

    return new RestTemplate(httpComponentsClientHttpRequestFactory);
}