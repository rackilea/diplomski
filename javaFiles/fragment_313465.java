Date date = new Date();
String datePart = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
String timePart = DateFormat.getTimeInstance(DateFormat.SHORT).format(date);

String dateAndTime = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date);

System.out.println("datePart = " + datePart);
System.out.println("timePart = " + timePart);
System.out.println("dateAndTime = " + dateAndTime);