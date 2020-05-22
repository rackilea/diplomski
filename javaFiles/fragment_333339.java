@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter
        implements EmbeddedServletContainerCustomizer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Resources without Spring Security. No cache control response headers.
        registry.addResourceHandler("/static/public/**")
            .addResourceLocations("classpath:/static/public/");

        // Resources controlled by Spring Security, which
        // adds "Cache-Control: must-revalidate".
        registry.addResourceHandler("/static/**")
            .addResourceLocations("classpath:/static/")
            .setCachePeriod(3600*24);
    }
}