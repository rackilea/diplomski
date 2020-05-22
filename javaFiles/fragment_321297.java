@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {
    @Bean
    public DTOJackonMessageConverter customJackson2HttpMessageConverter() {
        return new DTOJackonMessageConverter();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customJackson2HttpMessageConverter());
        super.addDefaultHttpMessageConverters(converters);
    }
}