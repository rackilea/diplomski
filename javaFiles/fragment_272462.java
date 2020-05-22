@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

  @Value("${local}")
  private Boolean local;

  //Used in addition of @PropertySource
  @Bean
  public static PropertySourcesPlaceholderConfigurer   propertySourcesPlaceholderConfigurer() {
      return new PropertySourcesPlaceholderConfigurer();
  }

}