@Configuration
public class appConfig{
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean
  ObjectMapper objectMapper(){
    return new ObjectMapper();
  }
}