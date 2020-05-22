@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    @Autowired
    private ObjectMapperBean objectMapper;

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }

}