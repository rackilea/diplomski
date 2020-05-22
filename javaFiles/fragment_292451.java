public Instant getPreviousOccurence(LocalTime scheduledTime) {
    Instant now = Instant.now();
    ZonedDateTime todayAtScheduledTime = ZonedDateTime.ofInstant(now, EUROPE_PARIS).with(scheduledTime).withEarlierOffsetAtOverlap();
    if (todayAtScheduledTime.toInstant().isAfter(now)) {
        return todayAtScheduledTime.minusDays(1).withEarlierOffsetAtOverlap().toInstant();
    } else {
        return todayAtScheduledTime.toInstant();
    }
}