System.out.println( "dateIn: " + dateIn ); // j.u.Date's "toString" method applies JVM's default time zone. Very confusing, as a j.u.Date has no time zone.
System.out.println( "dateTimeUtc: " + dateTimeUtc );
System.out.println( "dateTimeLos_Angeles: " + dateTimeLos_Angeles );
System.out.println( "dateTimeKolkata: " + dateTimeKolkata );
System.out.println( "dateOut: " + dateOut ); // j.u.Date's "toString" method uses a terrible format. Use only in a pinch like debugging, never in production.
System.out.println( "Milliseconds since Unix epoch: " + dateIn.getTime() + " | " + dateTimeUtc.getMillis() + " | " + dateTimeLos_Angeles.getMillis() + " | " + dateTimeKolkata.getMillis() + " | " + dateOut.getTime()  );