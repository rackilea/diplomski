public static class WrapperDeserializer extends JsonDeserializer<Wrapper<?>> implements ContextualDeserializer {
    private JavaType valueType;

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JavaType wrapperType = property.getType();
        JavaType valueType = wrapperType.containedType(0);
        WrapperDeserializer deserializer = new WrapperDeserializer();
        deserializer.valueType = valueType;
        return deserializer;
    }

    @Override
    public Wrapper<?> deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        Wrapper<?> wrapper = new Wrapper<>();
        wrapper.value = ctxt.readValue(parser, valueType);
        return wrapper;
    }
}