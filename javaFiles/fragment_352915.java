Instant now = Instant.now();
LocalDateTime start = now.atOffset(ZoneOffset.UTC).toLocalDateTime();
LocalDateTime end = 
  start.plusYears(duration.getYears())
  .plusMonths(duration.getMonths())
  .plusDays(duration.getDays())
  .plusHours(duration.getHours())
  .plusMinutes(duration.getMinutes())
  .plusSeconds(duration.getSeconds());
long deltaInMillis = end.toInstant(ZoneOffset.UTC).toEpochMilli() - now.toEpochMilli();