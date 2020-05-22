String s1 = "Oct 5 11:05:03";
String s2 = "Oct 5 1996 13:51:56"; // Year supplied
String format = "MMM d [uuuu ]HH:mm:ss";

DateTimeFormatter f = new DateTimeFormatterBuilder()
    .appendPattern(format)
    .parseDefaulting(ChronoField.YEAR, Year.now().getValue())
    .toFormatter(Locale.US);

System.out.println(LocalDate.parse(s1, f));
System.out.println(LocalDate.parse(s2, f));