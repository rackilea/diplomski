Time time = Time.valueOf("00:04:00"); // replace with rs.getTime()
Calendar cal = Calendar.getInstance();
cal.setTime(time);
int hour = cal.get(Calendar.HOUR);
int minute = cal.get(Calendar.MINUTE);
int second = cal.get(Calendar.SECOND);
int ms = (hour * 3600 + minute * 60 + second) * 1000;
System.out.println("ms: " + ms);