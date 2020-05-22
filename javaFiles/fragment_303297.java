// If you have Java 8 or later, use the built-in java.time package.

java.time.Instant instant = ts.toInstant();
java.time.ZoneId zoneId = ZoneId.of( "America/Montreal" );
java.time.ZonedDateTime zdt = java.time.ZonedDateTime.ofInstant( instant , zoneId );

String output_UTC = instant.toString();
String output_Montréal = zdt.toString();

System.out.println( "output_SqlTimestamp: " + output_SqlTimestamp );  
System.out.println( "output_UTC: " + output_UTC );
System.out.println( "output_Montréal: " + output_Montréal );