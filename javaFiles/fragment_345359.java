@Provider
@Priority(Integer.MIN_VALUE)
public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {
    private ObjectMapper mapper;

    public ObjectMapperResolver() {
        JSON swaggerResolver = new JSON(); 
        mapper = swaggerResolver.getContext(null);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> cls) {
        return mapper;
    }
}