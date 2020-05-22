@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper>
{
    private final ObjectMapper objectMapper;

    public JacksonConfig() throws Exception
    {
        objectMapper = new ObjectMapper.configure(
                           SerializationFeature.WRITE_DATE_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> arg0)
    {
        return objectMapper;
    }
 }