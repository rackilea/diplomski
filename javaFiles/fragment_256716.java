@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rootpackage.api")
public class ApiConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("/**").addResourceLocations("/public-resources/");
    }
}