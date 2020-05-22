@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addRedirectViewController("/my/path/", "/my/path")
      .setKeepQueryParams(true)
      .setStatusCode(HttpStatus.PERMANENT_REDIRECT); 
}