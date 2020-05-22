@Configuration
@EnableWebMvc
@ComponentScan
public class TestDataConfig extends WebMvcConfigurationSupport {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converters.add(converter);
        super.addDefaultHttpMessageConverters(); // Have to call this explicitly to register Default Message Converters.
    }
}