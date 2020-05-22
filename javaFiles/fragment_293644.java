public static class MyDeserializer implements JsonDeserializer {
    private Class<?> implClass;

    public BookDeserializer(Class<?> c) {
        implClass = c;
    }

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, 
            JsonDeserializationContext context) throws JsonParseException {
        return context.deserialize(json, implClass);
    }
}