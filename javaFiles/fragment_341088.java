// Get start moment for a particular time zone.
public ZonedDateTime toStartMoment ( ZoneId zoneId ) {
    ZonedDateTime zdt = this.toInterval( zoneId ).getStart().atZone( zoneId );
    return zdt;
}

// Get stop moment for a particular time zone.
public ZonedDateTime toStopMoment ( ZoneId zoneId ) {
    ZonedDateTime zdt = this.toInterval( zoneId ).getEnd().atZone( zoneId );
    return zdt;
}