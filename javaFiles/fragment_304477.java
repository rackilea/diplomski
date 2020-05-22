SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
sd.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
Date dateValue = sd.parse("2015-09-30");
System.out.println(dateValue); // prints "Tue Sep 29 13:00:00 CEST 2015"

Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Pacific/Auckland")); // set correct timezone to calendar
calendar.setTime(dateValue);
calendar.add(Calendar.DAY_OF_MONTH, -6);
dateValue = calendar.getTime();
System.out.println(dateValue); // prints "Wed Sep 23 14:00:00 CEST 2015"