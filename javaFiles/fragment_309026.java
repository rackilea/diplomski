@FeignClient(name = "testClient", url = "https://test:9820", configuration = CustomFeignConfiguration.class)
public interface TestClient {
@RequestMapping(method = RequestMethod.POST, value = "/test", consumes = 
"application/json", produces = "application/json")
   TesteDto get(TestRequestDto testRequestDto);
}
public class CustomFeignConfiguration {
@Bean
public Client feignClient() {
  return new ApacheHttpClient(getHttpClient());
}

private CloseableHttpClient getHttpClient() {
int timeout = 10000;
try {
  SSLContext sslContext = SSLContextBuilder.create()
      .loadTrustMaterial(new TrustSelfSignedStrategy()).build();
  RequestConfig config = RequestConfig.custom()
      .setConnectTimeout(timeout)
      .setConnectionRequestTimeout(timeout)
      .setSocketTimeout(timeout)
      .build();
  return HttpClientBuilder
      .create()
      .useSystemProperties()
      .setDefaultRequestConfig(config)
      .setSSLContext(sslContext)
      .setSSLHostnameVerifier(new NoopHostnameVerifier())
      .build();
} catch (Exception e) {
  throw new RuntimeException();
   }
  }
}