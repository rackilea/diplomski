@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
//..

  @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("test");
    }
//..
}