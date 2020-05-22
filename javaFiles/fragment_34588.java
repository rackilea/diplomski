@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    final ObjectMapper listMapper = new ObjectMapper();
    final ObjectMapper defaultMapper = new ObjectMapper();

    public ObjectMapperContextResolver() {
        listMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        listMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);

        listMapper.registerModule(new JaxbAnnotationModule());
        defaultMapper.registerModule(new JaxbAnnotationModule());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        if (type == MovieList.class) {
            return listMapper;
        }
        return defaultMapper;
    }  
}