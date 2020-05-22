final class ZonedDateTimeTypeAdapter
        extends TypeAdapter<ZonedDateTime> {

    private static final TypeAdapter<ZonedDateTime> zonedDateTimeTypeAdapter = new ZonedDateTimeTypeAdapter().nullSafe();

    private ZonedDateTimeTypeAdapter() {
    }

    static TypeAdapter<ZonedDateTime> getZonedDateTimeTypeAdapter() {
        return zonedDateTimeTypeAdapter;
    }

    @Override
    public void write(final JsonWriter out, final ZonedDateTime zonedDateTime) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ZonedDateTime read(final JsonReader in)
            throws IOException {
        try {
            final String s = in.nextString();
            return ZonedDateTime.parse(s, customDateTimeFormatter);
        } catch ( final DateTimeParseException ex ) {
            throw new JsonParseException(ex);
        }
    }

}