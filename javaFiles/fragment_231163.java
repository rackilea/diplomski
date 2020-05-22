Locale l = Locale.getDefault();
System.out.println( l + "\n" );
Long d = new Long( 1293840000000l );

Calendar c = Calendar.getInstance();
c.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
c.setTime( new Date( d ) );

// Running Java 8 Update 11, Mac OS 10.8.5, virtual machine in Parallels 9, hosted on Mac with Mavericks.

// Force the use of default settings found on a machine set for United States locale (using Apple defaults).
c.setFirstDayOfWeek( 1 );
c.setMinimalDaysInFirstWeek( 1 );
// Reports: WEEK_OF_YEAR=1
System.out.println( "Default US settings:\n" + c.toString() + "\n" );

// Using reported settings (Coincides with ISO 8601 Week definition).
c.setFirstDayOfWeek( 2 );
c.setMinimalDaysInFirstWeek( 4 );
// Reports: WEEK_OF_YEAR=52
System.out.println( "Reported settings (ISO 8601):\n" + c.toString() + "\n" );