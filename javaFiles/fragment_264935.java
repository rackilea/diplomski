public void testInstant(){
    Instant now = Instant.now();
    ZonedDateTime utc = now.atZone(ZoneId.of("UTC"));

    ZonedDateTime zonedDateTime = utc.withHour(19)
            .withMinute(0)
            .withSecond(0);

    Instant instant = zonedDateTime.toInstant();
}