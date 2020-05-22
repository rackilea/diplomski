@Configuration
@Profile("azure")
public class AzureConfiguration {
  @Bean
  public ImageSearchService imageSearchService() {
    return new AzureImageSearchImpl();
  }
}

@Configuration
@Profile("google")
public class GoogleConfiguration {
  @Bean
  public ImageSearchService imageSearchService() {
    return new GoogleImageSearchImpl();
  }
}