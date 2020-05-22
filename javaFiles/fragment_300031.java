@Configuration
public class ThymeleafConfig {

  @Bean
  public MyDialect myDialect() {
    return new MyDialect();
  }
}