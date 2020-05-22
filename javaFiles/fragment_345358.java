@Provider
public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {
    private ObjectMapper mapper;

    public ObjectMapperResolver() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> cls) {
        return mapper;
    }
}