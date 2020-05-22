Date date = new Date();
DateFormat format = new SimpleDateFormat("dd/MM/yy h:mm a zzz");

format.setTimeZone(TimeZone.getTimeZone("America/New_York"));
System.out.println("Eastern: " + format.format(date));

format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
System.out.println("UTC: " + format.format(date));