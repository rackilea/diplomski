@Bean
public RestTemplate restTemplate(){
  return new RestTemplate(clientHttpRequestFactory());
}
private ClientHttpRequestFactory clientHttpRequestFactory(){
  HttpComponentsClientHttpRequestFactory .......
  factory.setConnectTime(...);
  return factory
}