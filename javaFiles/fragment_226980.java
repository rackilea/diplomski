@Configuration
public class BConfiguration extends WebMVCConfigurationSupport {
    protected void configureMessageConverters(List<HttpMessageConverters<?>> converters){
        converters.add(convert());
        addDefaultHttpMessageConverters(converters);
    }
    @Bean
    MappingJackson2HttpMessageConverter convert(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Field.class, new JsonBFieldDeserializer());
        objectMapper.registerModule(module);
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}