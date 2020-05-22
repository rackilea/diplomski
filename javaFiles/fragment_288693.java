String value = "Sunday, September 29, 2013 7:59:58 AM PDT";
String format = "EEEE, MMMM dd, yyyy h:mm:ss a zzz";

DateTimeFormatter formatter = new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .appendPattern(format)
        .toFormatter(Locale.US);
ZonedDateTime zdt = ZonedDateTime.parse(value, formatter);
System.out.println(zdt);
System.out.println(zdt.format(formatter));