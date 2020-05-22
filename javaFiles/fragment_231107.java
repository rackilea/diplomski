private final void _serializeAsArrayContents(LocalDateTime value, JsonGenerator g, SerializerProvider provider) throws IOException {
    g.writeNumber(value.getYear());
    g.writeNumber(value.getMonthValue());
    g.writeNumber(value.getDayOfMonth());
    g.writeNumber(value.getHour());
    g.writeNumber(value.getMinute());
    int secs = value.getSecond();
    int nanos = value.getNano();
    if (secs > 0 || nanos > 0) {
        g.writeNumber(secs);
        if (nanos > 0) {
            if (this.useNanoseconds(provider)) {
                g.writeNumber(nanos);
            } else {
                g.writeNumber(value.get(ChronoField.MILLI_OF_SECOND));
            }
        }
    }
}