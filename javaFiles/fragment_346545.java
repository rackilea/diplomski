@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired 
  MyInterceptor myInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(...)
    ...
    registry.addInterceptor(myInterceptor);
  }
}