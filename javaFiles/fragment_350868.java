@Configuration
public class RestTemplateConfiguration {
  @Bean
  public RestTemplate restTemplate() {
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntityErrorHandler errorHandler = new ResponseEntityErrorHandler();
      errorHandler.setMessageConverters(restTemplate.getMessageConverters());
      restTemplate.setErrorHandler(errorHandler); 
      return restTemplate;
   }
}