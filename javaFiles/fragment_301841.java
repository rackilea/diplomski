// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.

// Using US west coast time zone because March 9, 2014 at 02:00 is the start of DST Daylight Saving Time.
org.joda.time.DateTimeZone californiaTimeZone = org.joda.time.DateTimeZone.forID("America/Los_Angeles");

org.joda.time.DateTime now = new org.joda.time.DateTime(californiaTimeZone);

// Note the arbitrary choice of times (14 & 21 hours) assigned to new DateTimes.
org.joda.time.DateTime march_8_2014 = new org.joda.time.DateTime( 2014, 3, 8, 14, 0);
org.joda.time.DateTime march_9_2014 = new org.joda.time.DateTime( 2014, 3, 9, 21, 0);

int daysUntil8th = org.joda.time.Days.daysBetween( now , march_8_2014 ).getDays();
int daysUntil9th = org.joda.time.Days.daysBetween( now , march_9_2014 ).getDays();

// If you want whole days, call 'withTimeAtStartOfDate()' method.
// Don't get clever with trying to set a midnight time. Not every day in every time zone has a midnight.
int daysUntil8thStarts = org.joda.time.Days.daysBetween( now , march_8_2014.withTimeAtStartOfDay() ).getDays();
int daysUntil9thStarts = org.joda.time.Days.daysBetween( now , march_9_2014.withTimeAtStartOfDay() ).getDays();

System.out.println("Now in 'America/Los_Angeles' (Pacific Standard Time): " + now );

System.out.println("Days until " +  march_8_2014 + ": " + daysUntil8th );
System.out.println("Days until " + march_9_2014 + ": " + daysUntil9th );

System.out.println("Days until March 8, 2014 starts: " + daysUntil8thStarts );
System.out.println("Days until March 9, 2014 starts: " + daysUntil9thStarts );