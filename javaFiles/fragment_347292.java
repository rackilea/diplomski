ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());

DateTimeFormatter outputFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
String output = outputFormatter.format(zdt);

System.out.println(input);
System.out.println(output);