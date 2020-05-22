String datePattern = "\\d{2}-\\d{2}-\\d{4}";

String date1 = "200000-05-16";
String date2 = "05-16-2000";

Boolean isDate1 = date1.matches(datePattern);
Boolean isDate2 = date2.matches(datePattern);

System.out.println(isDate1);
System.out.println(isDate2);