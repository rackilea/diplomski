public String getZonedDateString(Date date, ZoneId targetZoneId) {
    ZoneId zoneId = ZoneOffset.UTC; // This should be the zone of your database
    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), zoneId);
    ZonedDateTime newZonedDateTime = zonedDateTime.withZoneSameInstant(targetZoneId);
    return DateTimeFormatter.ofPattern("MMM d yyy hh:mm") .format(newZonedDateTime);
}