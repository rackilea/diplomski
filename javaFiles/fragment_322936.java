org.joda.time.DateTimeZone parisDateTimeZone = org.joda.time.DateTimeZone.forID( "Europe/Paris" );
org.joda.time.DateTime q1Start =  new org.joda.time.DateTime(2013, 1, 1, 0, 0, parisDateTimeZone ).withTimeAtStartOfDay();
org.joda.time.DateTime q2Start =  new org.joda.time.DateTime(2013, 4, 1, 0, 0, parisDateTimeZone ).withTimeAtStartOfDay();

System.out.println( "Q1 begins in Paris FR: " + q1Start );
System.out.println( "Q2 begins in Paris FR: " + q2Start );

// When querying a database or comparing items in a collection to find Q1 data, 
// Look for: (GreaterThanOrEqualTo q1Start) AND (LessThan q2Start)