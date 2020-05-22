//DateTime now = new DateTime(); // Default time zone automatically assigned.

// Convert a java.util.Date to Joda-Time.
java.util.Date date = new java.util.Date();
DateTime now = new DateTime( date );  // Default time zone automatically assigned.

DateTimeZone timeZone = DateTimeZone.forID( "Asia/Kolkata" );
DateTime nowIndia = now.toDateTime( timeZone );

// For UTC/GMT, use built-in constant.
DateTime nowUtcGmt = nowIndia.toDateTime( DateTimeZone.UTC );

// Convert from Joda-Time to java.util.Date.
java.util.Date date2 = nowIndia.toDate();