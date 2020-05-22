@Configuration
public class AppConfig {
  @Bean
  public LoginService loginService() {
    return new LoginService();
  }
  ...
}