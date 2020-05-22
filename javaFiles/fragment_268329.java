@Configuration
public class MyConfig {

   @Bean
   public MovieClient movieClient(RestOperations rest) {
       return new MovieClientImpl(rest);
   }

   @Bean
   public RestOperations restOps() {
       return new RestTemplate();
   }

}