@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
      MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
      ObjectMapper mapper = new ObjectMapper() {
        private static final long serialVersionUID = 1L;
        @Override
        protected DefaultSerializerProvider _serializerProvider(SerializationConfig config) {
          // replace the configuration with my modified configuration.
          // calling "withView" should keep previous config and just add my changes.
          return super._serializerProvider(config.withView(TravelRequestView.MyRequests.class));
        }        
      };
      mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
      converter.setObjectMapper(mapper);
      converters.add(converter);
    }