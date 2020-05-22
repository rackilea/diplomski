java.util.Date date = new java.util.Date();

// Convert a Date into a Joda-Time DateTime.
// Specify a time zone rather than rely on default.
DateTimeZone timeZone = DateTimeZone.forID( "Europe/Istanbul" );
DateTime dateTime = new DateTime( date, timeZone );
DateTime dateTimeUtc = dateTime.withZone( DateTimeZone.UTC );