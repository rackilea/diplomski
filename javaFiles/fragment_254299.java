private static void some(final Date now, ZoneId zone) {
  Instant instant = now.toInstant();  // Convert from old legacy class to modern java.time class.
  ZonedDateTime zdt = instant.atZone(zone);  // Apply a time zone to the UTC value.
  LocalDate today = zdt.toLocalDate();  // Extract a date-only value, without time-of-day and without time zone.

  ZonedDateTime startOfDayToday = today.atStartOfDay(zone);  // Determine first moment of the day.
  ZonedDateTime startOfDayTomorrow = today.plusDays(1).atStartOfDay(zone);

  // ...
}