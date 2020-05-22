// Somewhere before the method, as field for example
// Use other pool sizes if desired
ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

public static ScheduledFuture<?> scheduleFor(Runnable runnable, ZonedDateTime when) {
    Instant now = Instant.now();
    // Use a different resolution if desired
    long secondsUntil = ChronoUnit.SECONDS.between(now, when.toInstant());

    return scheduler.schedule(runnable, secondsUntil, TimeUnit.of(ChronoUnit.SECONDS));
}