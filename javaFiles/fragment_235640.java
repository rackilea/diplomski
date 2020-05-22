@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
  AuthentificationToken authentificationToken;

  @Autowired
  public CustomWebMvcConfigurerAdapter(AuthentificationToken authentificationToken) {
    this.authentificationToken = authentificationToken;
  }

  @Bean
  public CustomHandlerInterceptor customHandlerInterceptor() {
    return new CustomHandlerInterceptor(authentificationToken);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(customHandlerInterceptor());
  }
}