DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:00Z");
TimeZone tz = TimeZone.getTimeZone("IST"); // <-- Move this here.

Calendar cal = Calendar.getInstance();
cal.setTimeZone(tz);                       // <-- So we can use it here.
cal.set(Calendar.YEAR, 2013);
cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
cal.set(Calendar.DATE, 1);
cal.set(Calendar.HOUR_OF_DAY, 12);
cal.set(Calendar.MINUTE, 15);
Date date = cal.getTime();
dateFormat.setTimeZone(tz);                // <-- And here.