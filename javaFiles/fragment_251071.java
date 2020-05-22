Date date = new Date();
System.out.println("date = " + date);
SimpleDateFormat format = new SimpleDateFormat("EEE, MMM yy");
String dateToString = format.format(date);
System.out.println("dateToString = '" + dateToString + "'");
System.out.println("matches = " + dateToString.matches("\\w{3},\\s\\w{3}\\s\\d{2}"));