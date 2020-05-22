static void time() {
    final DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(fmt);
    Instant.now().atOffset(ZoneOffset.ofHours(1)).truncatedTo(ChronoUnit.SECONDS).format(fmt);
    Instant.now().atOffset(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS).format(fmt);
    OffsetDateTime.parse("2007-12-03T10:15:30+01:00").format(fmt);
    LocalDateTime.parse("2009-06-15T13:45:30").format(fmt);
}