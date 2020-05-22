// Using old Java Date
Date date = new Date((long) d * 1000);

SimpleDateFormat fmt = new SimpleDateFormat("EEE MMM d yyyy HH:mm:ss 'GMT'XX (z)");
fmt.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
System.out.println(fmt.format(date));