@Configuration
public class Config {

   @Bean
   public RestTemplate restTemplate() {
      return new RestTemplate();
   }

}