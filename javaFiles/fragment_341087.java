// Dynamically determine if this appointment will be in the future for some specific time zone.
public Boolean isFuture ( ZoneId zoneId ) {
    Objects.requireNonNull( zoneId , "Must pass a time zone to determine if an appointment is in the future. Message # e1c64bc1-9a44-4d15-b20d-e68414fb5ab5.");
    ZonedDateTime zdtStart = this.start.atZone( zoneId );
    ZonedDateTime zdtNow = ZonedDateTime.now( zoneId );
    boolean isInTheFuture = zdtNow.isBefore( zdtStart );
    return isInTheFuture ;
}