@Configuration
public class MyAutoConfiguration {

  @ConditionalOnMissingBean(B.class)
  @Bean
  public B defaultImplementation() { return A(); }

  @Bean
  public UsesB classThatUsesB(B b) { return UsesB(b); }

}