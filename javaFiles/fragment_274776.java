ZoneId utc = ZoneId.of("UTC");
ZonedDateTime startTime = startDate.atStartOfDay(utc);
ZonedDateTime endTime = endDate.atStartOfDay(utc).plusDays(1).minusNanos(1);

[...]

    .setParameter("startDate", startTime)
    .setParameter("endDate", endTime)