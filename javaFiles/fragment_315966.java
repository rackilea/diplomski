String actualDate = "2016-03-20";
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH);
LocalDate ld = LocalDate.parse(actualDate, dtf);
String month_name = dtf2.format(ld);
System.out.println(month_name); // Mar 2016