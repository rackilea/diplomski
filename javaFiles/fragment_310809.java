new JsonSerializer<T>() {
    @Override
    public void serialize(T instance, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException
    {
        try {
            instance = someFunction(instance);
            defaultMapper.writeValue(gen, instance)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}