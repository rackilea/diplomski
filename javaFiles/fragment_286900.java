@Configuration
class CustomConfiguration {

  @Bean
  @ConditionalOnClass(String.class)
  String knownClass() {
    return "Hello";
  }

  @Configuration
  @ConditionalOnClass(MissingClass.class)
  static class DoubtfulBeanConfiguration {

    @Bean
    MissingClass missingClass() {
      return new MissingClass();
    }

  }

}