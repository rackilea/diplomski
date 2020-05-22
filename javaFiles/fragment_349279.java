@Configuration
@EnableAutoConfiguration
public class ApplicationConfig extends WebMvcConfigurerAdapter {
  public static void main(String... args) {
    SpringApplication.run(ApplicationConfig.class, args);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(csrfTokenAddingInterceptor());
  }

  @Bean
  public HandlerInterceptor csrfTokenAddingInterceptor() {
    return new HandlerInterceptorAdapter() {
      @Override
      public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view) {
        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName())
        if (token != null) {
          view.addObject(token.getParameterName(), token)
        }
      }
    }
  }
}