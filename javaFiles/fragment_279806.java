String input = "07.Haz.2014";

java.util.Locale locale = new java.util.Locale( "tr", "TR" );
DateTimeZone timeZone = DateTimeZone.forID( "Europe/Istanbul" );  // Assuming this time zone (not specified in Question).
DateTimeFormatter formatter = DateTimeFormat.forPattern( "dd.MMM.yyyy" ).withLocale( locale ).withZone( timeZone );
DateTime dateTime = formatter.parseDateTime( input );
String outputQuébécois = DateTimeFormat.forStyle( "FF" ).withLocale( java.util.Locale.CANADA_FRENCH ).print( dateTime ); // 
DateTime dateTimeUtc = dateTime.withZone( DateTimeZone.UTC );