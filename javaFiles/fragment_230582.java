@Configuration
public class AppConfig {

   //add other beans

   @Bean
   public Offers DiwaliOffer() {
      return new Offers(10, diwali);
   }
}