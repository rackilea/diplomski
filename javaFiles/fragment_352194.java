String string = "Mon Feb 23 05:30:55 +0000 2015";

DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
Calendar date = Calendar.getInstance();
date.setTime(format.parse(string));
System.out.println(format.format(date.getTime())); // Mon Feb 23 05:30:55 GMT 2015          

int hours = date.get(Calendar.HOUR_OF_DAY); // 5
int minutes = date.get(Calendar.MINUTE); // 30

date.add(Calendar.HOUR_OF_DAY, 1); // add a hour
date.add(Calendar.MINUTE , 1); // add a minute
System.out.println(format.format(date.getTime())); // Mon Feb 23 06:31:55 GMT 2015