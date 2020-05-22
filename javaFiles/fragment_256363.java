@Configuration
public class MockServiceAutoconfiguration {

   @Profile({"mockAmazon", "mockAll", "mockAmazonAndEbay"})
   @Bean
   public ProductsService amazonProductsService() {
      return new MockAmazonProductsService();
   }

   @Profile({"mockAliexpress", "mockAll"})
   @Bean
   public ProductsService aliexpressProductsService() {
      return new MockAliexpressProductsService();
   }

}