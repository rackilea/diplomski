SimpleDateFormat formatter = new SimpleDateFormat("mm hh dd MM yyyy aa");
String date1 = "1412293500";
String date2 = "1412336700";
String dateString1 = formatter.format(Long.parseLong(date1 + "000"));
String dateString2 = formatter.format(Long.parseLong(date2 + "000"));
System.out.println(dateString1 + " " + dateString2); // prints 45 01 03 10 2014 AM 45 01 03 10 2014 PM