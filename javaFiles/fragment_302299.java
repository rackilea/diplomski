@Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
    poolingConnectionManager.setMaxTotal(restTemplateProps.getMaxConnectionsPerPool());
    poolingConnectionManager.setDefaultMaxPerRoute(restTemplateProps.getMaxDefaultConnectionPerRoute());
    CloseableHttpClient client = HttpClientBuilder.create().setConnectionManager(poolingConnectionManager).build();
    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(client);
    clientHttpRequestFactory.setConnectTimeout(restTemplateProps.getConnectionTimeout());
    clientHttpRequestFactory.setReadTimeout(restTemplateProps.getSocketTimeout());
    restTemplateBuilder = restTemplateBuilder.additionalInterceptors(new MyClientHttpRequestInterceptor());
    return restTemplateBuilder.requestFactory(clientHttpRequestFactory).build();
  }