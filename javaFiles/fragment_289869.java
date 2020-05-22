String input = "Fri Jan 24 12:22:13 +0000 2014";
DateTimeFormatter formatter = DateTimeFormat.forPattern( "EEE MMM dd HH:mm:ss Z yyyy" );

// Parse as UTC/GMT (no time zone offset) so we may conveniently compare to input.
DateTime dateTimeUtc = formatter.withZone( DateTimeZone.UTC ).parseDateTime( input );

// Convert to Hong Kong time zone. 
DateTime dateTimeHongKong = dateTimeUtc.toDateTime( DateTimeZone.forID( "Asia/Hong_Kong" ) );