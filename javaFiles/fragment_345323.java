class LongOrDoubleJsonDeserializer implements JsonDeserializer<Long> {

    @Override
    public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonPrimitive()) {
            Number number = json.getAsNumber();

            return number.longValue();
        }

        return null;
    }
}