private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

public static Long getMillisForDate(String date) {
    return LocalDateTime
            .of(LocalDate.parse(date, formatter), LocalTime.NOON)
            .atZone(ZoneOffset.UTC)
            .toInstant().toEpochMilli();
}