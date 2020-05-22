@Configuration
public class UserConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public UserProvider provideUser() {

    return new DefaultUserProvider();
  }
}