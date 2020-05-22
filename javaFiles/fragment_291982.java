public static ZoneOffset determineTimeZoneOffset(OffsetDateTime localTime, OffsetDateTime utcTime) {
  if(utcTime == null || localTime == null) {
    return null;
  }

  OffsetDateTime ceilingUtc = utcTime.truncatedTo(ChronoUnit.HOURS).plusHours(1);
  OffsetDateTime ceilingLocal = localTime.truncatedTo(ChronoUnit.HOURS).plusHours(1);

  int offsetHours = (int)ChronoUnit.HOURS.between(ceilingUtc, ceilingLocal);

  return ZoneOffset.ofHours(offsetHours);
}