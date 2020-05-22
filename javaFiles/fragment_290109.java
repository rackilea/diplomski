public class MappingJacksonFactory {

public static MappingJackson2HttpMessageConverter create() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = converter.getObjectMapper();
    objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
    objectMapper.enable(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
    SimpleModule module = new TypeModuleFactory();
    objectMapper.registerModule(module);
    return converter;
   }

}