public static class CharSequenceDeserializer implements JsonDeserializer<CharSequence> {

    @Override
    public CharSequence deserialize(JsonElement element, Type type,
            JsonDeserializationContext context) throws JsonParseException {
        return element.getAsString();
    }

}