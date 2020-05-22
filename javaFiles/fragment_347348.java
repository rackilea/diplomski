@Bean
public ObjectMapper serializingObjectMapper() {

    ObjectMapper objectMapper = new ObjectMapper();
    SimpleModule simpleModule = new SimpleModule();

    simpleModule.setDeserializerModifier(new BeanDeserializerModifier() {
        @Override
        public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
            if (Dto.class.isAssignableFrom(beanDesc.getBeanClass())) {
                return new JsonDtoDeserializer<>(deserializer, beanDesc.getBeanClass());
            }
            return deserializer;
        }
    });

    objectMapper.registerModule(simpleModule);
    return objectMapper;
}



public class JsonDtoDeserializer<T extends Dto> extends StdDeserializer<T> implements ResolvableDeserializer /*StdDeserializer<Dto<T>>*/ /*UntypedObjectDeserializer.Vanilla*/ /*<T>*/ /*implements ResolvableDeserializer*/ {

    private final JsonDeserializer<?> defaultDeserializer;

    public JsonDtoDeserializer(JsonDeserializer<?> defaultDeserializer, Class<?> clazz) {
        super(clazz);
        this.defaultDeserializer = defaultDeserializer;
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {

        @SuppressWarnings("unchecked")
        T itemObj = (T) defaultDeserializer.deserialize(p, ctxt);
        return itemObj;
    }

    // for some reason you have to implement ResolvableDeserializer when modifying BeanDeserializer
    // otherwise deserializing throws JsonMappingException??
    @Override public void resolve(DeserializationContext ctxt) throws JsonMappingException
    {
        ((ResolvableDeserializer) defaultDeserializer).resolve(ctxt);
    }
}