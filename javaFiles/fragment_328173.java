class ZonedDateTimeConverter implements Converter<String, ZonedDateTime> {
    private final ZoneId zoneId;

    public ZonedDateTimeConverter(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public ZonedDateTime convert(String source) {
        long startTime = Long.parseLong(source);
        return Instant.ofEpochSecond(startTime).atZone(zoneId);
    }
}