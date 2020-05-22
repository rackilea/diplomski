DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
long time = format.parse("2013-6-30").getTime();
String logTime = format.format(new Date(time + 25L * 24 * 3600 * 1000));
String logTime1 = format.format(new Date(time + 24L * 24 * 3600 * 1000));
System.out.println("time + 25d:  " + logTime);
System.out.println("time + 24d:  " + logTime1);