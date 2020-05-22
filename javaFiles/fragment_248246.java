String input = "2019-07-04 11:00:00.0";
System.out.println("input:   " + input);

SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
Date date = formatter.parse(input);
System.out.println("date:    " + date);

Instant instant = date.toInstant();
System.out.println("instant: " + instant);