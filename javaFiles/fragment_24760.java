public static class ValueWrapperDeserializer implements JsonDeserializer<ValueWrapper<?>> {
    @Override
    public ValueWrapper<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ParameterizedType parameterizedType = (ParameterizedType) typeOfT;
        Type valueType = parameterizedType.getActualTypeArguments()[0];
        Object value = context.deserialize(json, valueType);
        return new ValueWrapper<>(value, false);
    }
}