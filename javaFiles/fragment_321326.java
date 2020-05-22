final class ZonedDateTimeJsonDeserializer
        implements JsonDeserializer<ZonedDateTime> {

    private static final JsonDeserializer<ZonedDateTime> zonedDateTimeJsonDeserializer = new ZonedDateTimeJsonDeserializer();

    private ZonedDateTimeJsonDeserializer() {
    }

    static JsonDeserializer<ZonedDateTime> getZonedDateTimeJsonDeserializer() {
        return zonedDateTimeJsonDeserializer;
    }

    @Override
    public ZonedDateTime deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        try {
            final String s = context.deserialize(jsonElement, String.class);
            return ZonedDateTime.parse(s, customDateTimeFormatter);
        } catch ( final DateTimeParseException ex ) {
            throw new JsonParseException(ex);
        }
    }

}