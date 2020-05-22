// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
// import org.joda.time.*;
// import org.joda.time.format.*;

DateTimeFormatter formatter = DateTimeFormat.forPattern( "yyyy/MM/dd");
String string = "2013/12/17";

// Assuming the date is in UTC.
DateTime dateTimeInUtc = formatter.withZone( DateTimeZone.UTC ).parseDateTime( string ).withTimeAtStartOfDay();
long secondsSinceUnixEpoch_dateTimeInUtc = ( dateTimeInUtc.getMillis() / 1000 ); // Convert milliseconds to seconds.

// Assuming the date is in Kolkata (formerly known as Calcutta India).
DateTimeZone kolkataTimeZone = DateTimeZone.forID( "Asia/Kolkata" );
DateTime dateTimeInKolkata = formatter.withZone( kolkataTimeZone ).parseDateTime( string ).withTimeAtStartOfDay();
long secondsSinceUnixEpoch_dateTimeInKolkata = ( dateTimeInKolkata.getMillis() / 1000 ); // Convert milliseconds to seconds.