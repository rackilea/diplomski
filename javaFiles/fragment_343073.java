class ClassImplJsonDeserializer extends JsonDeserializer<ClassImpl> {
    @Override
    public ClassImpl deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return jp.readValuesAs(ClassImpl.class).next();
    }
}