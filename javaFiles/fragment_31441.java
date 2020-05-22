@Configuration
public class ContentNegotiationConfig extends WebMvcConfigurerAdapter {
    @Override
    void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
        // Turn off suffix-based content negotiation
        configurer.favorPathExtension(false);
    }
}