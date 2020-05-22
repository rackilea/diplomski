SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
String valueFromDB = "2012-12-31 00:00:00.0";
Date d1 = sdf1.parse(valueFromDB);
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
String dateWithoutTime = sdf.format(d1);
System.out.println("sdf.format(d) " + dateWithoutTime);