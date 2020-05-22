// getting next saturday midnight
LocalDateTime nextSaturdayMidnight = LocalDateTime.now()
    // truncating to midnight
    .truncatedTo(ChronoUnit.DAYS)
    // adding adjustment to next saturday
    .with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

// getting hours until next saturday midnight
long hoursUntilNextSaturdayMidnight = LocalDateTime.now()
    // getting offset in hours
    .until(nextSaturdayMidnight, ChronoUnit.HOURS);

// getting minutes until...
long minutesUntilNextSaturdayMidnight = LocalDateTime.now()
    // getting offset in minutes
    .until(nextSaturdayMidnight, ChronoUnit.MINUTES);