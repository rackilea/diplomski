String time = "15:54";

Date date = new Date();
java.util.TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // ADDED THIS LINE
date.setHours(Integer.parseInt(time.substring(0, 2)));

long hours = (date.getTime() / (60 * 60 * 1000)) % 24;

System.out.print(hours); // NOW THIS GIVES 15
System.out.print("\n" + date.getHours()); // 15