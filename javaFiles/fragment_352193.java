String string = "Mon Feb 23 05:30:55 +0000 2015";

DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
Date date = format.parse(string);
System.out.println(date); // Mon Feb 23 05:30:55 GMT 2015

int hours = date.getHours();
date.setHours(hours + 1);
System.out.println(date); // Mon Feb 23 06:30:55 GMT 2015