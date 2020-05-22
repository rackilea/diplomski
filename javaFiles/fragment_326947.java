@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired 
  HandlerInterceptor yourInjectedInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(...)
    ...
    registry.addInterceptor(getYourInterceptor()); 
    registry.addInterceptor(yourInjectedInterceptor);
    // next two should be avoid -- tightly coupled and not very testable
    registry.addInterceptor(new YourInterceptor());
    registry.addInterceptor(new HandlerInterceptor() {
        ...
    });
  }
}