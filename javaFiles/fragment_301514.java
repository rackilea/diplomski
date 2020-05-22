@Value("${http.client.ssl.trust-store}")
private Resource keyStore;
@Value("${http.client.ssl.trust-store-password}")
private String keyStorePassword;

@Bean
RestTemplate restTemplate() throws Exception {
    SSLContext sslContext = new SSLContextBuilder()
            .loadTrustMaterial(
                    keyStore.getURL(),
                    keyStorePassword.toCharArray()
            ).build();
    SSLConnectionSocketFactory socketFactory =
            new SSLConnectionSocketFactory(sslContext);
    HttpClient httpClient = HttpClients.custom()
            .setSSLSocketFactory(socketFactory).build();
    HttpComponentsClientHttpRequestFactory factory =
            new HttpComponentsClientHttpRequestFactory(httpClient);
    return new RestTemplate(factory);
}