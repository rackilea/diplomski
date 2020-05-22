@Provider
public class CustomJacksonConfig implements ContextResolver<ObjectMapper> {
    private ObjectMapper objectMapper;

    public JacksonConfig() {
        this.objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null));
        module.addSerializer(AccountBean.class, new AccountSerializer());
        this.objectMapper.registerModule(module);
    }

    public ObjectMapper getContext(Class<?> objectType) {
        return objectMapper;
    }
}