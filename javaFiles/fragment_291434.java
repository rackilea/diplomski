@TestConfiguration
static class TestContextConfiguration {
   @Bean
   public MethodValidationPostProcessor bean() {
      return new MethodValidationPostProcessor();
   }
}