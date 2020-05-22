long unixSeconds = 1372339860;
// convert seconds to milliseconds
Date date = new java.util.Date(unixSeconds*1000L); 
// the format of your date
SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); 
// give a timezone reference for formatting (see comment at the bottom)
sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4")); 
String formattedDate = sdf.format(date);
System.out.println(formattedDate);