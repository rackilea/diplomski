private static final LocalTime EARLY_CUTOFF = LocalTime.of(1, 0);
private static final LocalTime LATE_CUTOFF = LocalTime.of(14, 0);

ZoneId zone = ZoneId.of("America/New_York");
LocalTime time = ZonedDateTime.now(zone).toLocalTime();
if (time.compareTo(EARLY_CUTOFF) < 0 && time.compareTo(LATE_CUTOFF) >= 0) {
    ...
}