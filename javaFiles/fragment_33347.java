class OneOrElementJsonDeserializer<T> implements JsonDeserializer<T> {

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json instanceof JsonArray) {
            final JsonArray array = (JsonArray) json;
            final int size = array.size();
            if (size == 0) {
                return null;
            }

            return context.deserialize(array.get(0), typeOfT);
        }

        return context.deserialize(json, typeOfT);
    }
}