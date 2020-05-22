@Provider
public class AvroMapperProvider implements ContextResolver<ObjectMapper> {

    final AvroMapper avroMapper = new AvroMapper();

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return avroMapper;
    }
}