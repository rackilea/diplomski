Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
c.set(Calendar.HOUR_OF_DAY, 0);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);
long unixTimeStamp = c.getTimeInMillis() / 1000;