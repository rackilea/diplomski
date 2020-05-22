Date date = new Date();
System.out.println("Date: " + date);

DateFormat df = new SimpleDateFormat("hh:'00' a");
String hour = df.format(date);
System.out.println("Hour: " + hour);