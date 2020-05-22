String str_date1 = "26/02/2011";
String str_time1 = "11:00 AM";

String str_date2 = "27/02/2011";
String str_time2 = "12:15 AM" ;

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
Date date1 = formatter.parse(str_date1 + " " + str_time1);
Date date2 = formatter.parse(str_date2 + " " + str_time2);

// Get msec from each, and subtract.
long diff = date2.getTime() - date1.getTime();

System.out.println("Difference In Days: " + (diff / (1000 * 60 * 60 * 24)));