final class YnToBooleanJsonDeserializer
        implements JsonDeserializer<Boolean> {

    // Gson will instantiate this adapter itself
    private YnToBooleanJsonDeserializer() {
    }

    @Override
    public Boolean deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        final String rawFlag = jsonElement.getAsString();
        switch ( rawFlag ) {
        case "N":
            return false;
        case "Y":
            return true;
        default:
            throw new JsonParseException("Can't parse: " + rawFlag);
        }
    }

}