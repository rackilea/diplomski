@Configuration
@EnableWebMvc
@ComponentScan(value = "com.roler.api")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
    }

    @Bean
    MappingJackson2HttpMessageConverter jacksonConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    // added to support plain text Spring responses
    @Bean
    StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter();
    }
...