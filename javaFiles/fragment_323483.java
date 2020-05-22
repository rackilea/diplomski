LocalDateTime nextFirework = LocalDate.now()
                             .with(TemporalAdjusters.firstDayOfNextYear())
                             .atTime(LocalTime.MIDNIGHT);
LocalDateTime now = LocalDateTime.now();

// duration (in seconds and nanos)
Duration duration = Duration.between(now, nextFirework);
// duration in total hours
long hours = now.until(nextFirework, ChronoUnit.HOURS);
// equals to: duration.toHours();