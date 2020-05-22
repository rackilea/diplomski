SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
f.setLenient(false);
Date date = f.parse("06/09/2015123"); // Here I inserted year 2015123.
System.out.println(date); // Sat Jun 09 00:00:00 CEST 2015123
GregorianCalendar cal = new GregorianCalendar();
cal.setTime(date);
System.out.println("Out of range: " + (cal.get(Calendar.YEAR) > 9999)); // Out of range: true