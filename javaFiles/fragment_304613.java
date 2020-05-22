DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

String todayAsString = dateFormat.format(today);
String tomorrowAsString = dateFormat.format(tomorrow);

System.out.println(todayAsString);
System.out.println(tomorrowAsString);