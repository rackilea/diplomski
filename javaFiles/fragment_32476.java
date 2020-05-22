DateTimeFormatter dtf = DateTimeFormat.forPattern("ZZ");

DateTimeZone zone;

zone = DateTimeZone.forID("America/Los_Angeles");
System.out.println(dtf.withZone(zone).print(0));  // Outputs -08:00

zone = DateTimeZone.forOffsetHoursMinutes(-5, 0);
System.out.println(dtf.withZone(zone).print(0)); // Outputs -05:00

DateTime dt = DateTime.now();
System.out.println(dtf.print(dt)); // Outputs -05:00 (time-zone dependent)