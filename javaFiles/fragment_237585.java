String input = "2013-12-11 21:25:04.800842+01";
String string = input.replace( " ", "T" ); // Replace SPACE with "T" for strict ISO 8601 format.

DateTime dateTimeUtc = new DateTime( string, DateTimeZone.UTC );

DateTimeZone timeZone = DateTimeZone.forID( "Europe/Paris" );
DateTime dateTimeParis = new DateTime( string, timeZone );