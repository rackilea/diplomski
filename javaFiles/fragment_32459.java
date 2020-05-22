DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String timestamp = "2016-02-16 11:00:02";
    TemporalAccessor temporalAccessor = formatter.parse(timestamp);
    LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
    Instant result = Instant.from(zonedDateTime);