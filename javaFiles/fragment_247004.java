@Bean
  public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
    PoolingHttpClientConnectionManager result = new PoolingHttpClientConnectionManager();
    result.setMaxTotal(20);  // FIXME Consider making this value configurable
    return result;
  }

  @Bean
  public RequestConfig requestConfig() {
    RequestConfig result = RequestConfig.custom()
      // FIXME Consider making these values configurable
      .setConnectionRequestTimeout(2000)
      .setConnectTimeout(2000)
      .setSocketTimeout(2000)
      .build();
    return result;
  }

  @Bean
  public CloseableHttpClient httpClient(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager, RequestConfig requestConfig) {
    CloseableHttpClient result = HttpClientBuilder
      .create()
      .setConnectionManager(poolingHttpClientConnectionManager)
      .setDefaultRequestConfig(requestConfig)
      .build();
    return result;
  }

  @Bean
  public RestTemplate restTemplate(HttpClient httpClient) {
    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(httpClient);
    return new RestTemplate(requestFactory);
  }