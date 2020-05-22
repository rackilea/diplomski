private static OffsetDateTime getReferenceDate(int seg) {
    int baseYear = 1970;
    if (seg >= 31 && seg <= 33) {
        baseYear = 1980; 
    }
    return OffsetDateTime.of(LocalDate.of(baseYear, Month.JANUARY, 1), 
                             LocalTime.MIDNIGHT,
                             ZoneOffset.UTC);
}

private static OffsetDateTime getDateFormat(int time, int seg) {
    return getReferenceDate(seg).plusSeconds(time);
}