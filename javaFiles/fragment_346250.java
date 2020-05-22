String string = "20131216014500+0000";
DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMddHHmmssZ");
DateTime dateTime = formatter.parseDateTime( string ); // Default time zone.

// Shift time zone to UTC/GMT.
DateTime dateTimeUtc = dateTime.toDateTime( DateTimeZone.UTC );

// Shift time zone to a named time zone.
// Guessing that "Europe/Madrid" is appropriate for Málaga Spain.
DateTime dateTimeMálaga = dateTime.toDateTime( DateTimeZone.forID( "Europe/Madrid" ) );