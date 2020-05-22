c.set(1582, Calendar.OCTOBER, 15, 0, 0, 0);
    d = c.getTime();
    System.out.println("Date: " + d + " (" + d.getTime() + " milliseconds)");
    System.out.println("ISO: " + new DateTime(d, ISOChronology.getInstance(DateTimeZone.forID("UTC"))));
    System.out.println("Julian+Gregorian: " + new DateTime(d, GJChronology.getInstance(DateTimeZone.forID("UTC"))));
    System.out.println("Julian: " + new DateTime(d, JulianChronology.getInstance(DateTimeZone.forID("UTC"))));
    System.out.println("Gregorian: " + new DateTime(d, GregorianChronology.getInstance(DateTimeZone.forID("UTC"))));