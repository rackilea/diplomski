// Before Java 8, use Joda-Time. (Joda-Time was the inspiration for java.time.)
// IMPORTANT: Joda-Time, like java.util.Date, is limited to milliseconds for fraction of a second. So you may experience data loss from a Postgres date-time value with microseconds.

org.joda.time.DateTime dateTimeMontréal = new org.joda.time.DateTime( ts.getTime() , DateTimeZone.forID( "America/Montreal" ) );  // WARNING: Data lost with microseconds truncated to milliseconds.
org.joda.time.DateTime dateTimeUtc = dateTimeMontréal.withZone( DateTimeZone.UTC );

String output_Joda_dateTimeMontréal = dateTimeMontréal.toString();
String output_Joda_dateTimeUtc = dateTimeUtc.toString();

System.out.println( "output_Joda_dateTimeMontréal: " + output_Joda_dateTimeMontréal );
System.out.println( "output_Joda_dateTimeUtc: " + output_Joda_dateTimeUtc );