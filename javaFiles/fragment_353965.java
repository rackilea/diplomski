@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/login").setViewName("login");
   }
}