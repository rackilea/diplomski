public ZonedDateTime addDays(long myUTCTimeInSeconds, int days) {
    Instant instant = Instant.ofEpochSecond(myUTCTimeInSeconds);
    ZonedDateTime dateTimeWithOffSet = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
    if (localDays >= 0) {
        dateTimeWithOffSet = dateTimeWithOffSet.plusDays(localDays);
    } else {
        dateTimeWithOffSet = dateTimeWithOffSet.minusDays(abs(localDays));
    }
    return dateTimeWithOffSet;
}