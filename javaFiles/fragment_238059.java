@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    ObjectMapper mapper = Jackson2ObjectMapperBuilder().json()
       .filters(new SimpleFilterProvider().addFilter("filter", new ExcludeIdFilter()));

    MappingJackson2HttpMessageConverter converter = 
        new MappingJackson2HttpMessageConverter(mapper);

    // then replace the default MappingJackson2HttpMessageConverter
    // with your custom one in the list of configured converters
  }

}