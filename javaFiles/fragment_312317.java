// Implicitly uses system time zone and system clock
ZonedDateTime now = ZonedDateTime.now();
ZonedDateTime thirtyDaysAgo = now.plusDays(-30);

if (eventStartDate.toInstant().isBefore(thirtyDaysAgo.toInstant())) {
    ...
}