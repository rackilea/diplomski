class MyJsonDeserializer implements JsonDeserializer<ImmutableList<?>> {
    @Override
    public ImmutableList<?> deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        final Type type2 = ParameterizedTypeImpl.make(List.class, ((ParameterizedType) type).getActualTypeArguments(), null);
        final List<?> list = context.deserialize(json, type2);
        return ImmutableList.copyOf(list);
    }
}