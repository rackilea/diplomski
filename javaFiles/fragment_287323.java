String format = "EEE, dd MMM yyyy HH:mm:ss z";
String input = "Mon, 14 May 2018 11:47:11 GMT";
SimpleDateFormat parser = new SimpleDateFormat(format, Locale.UK);
Date date = parser.parse(input);
parser.setTimeZone(TimeZone.getTimeZone("GMT"));
System.out.println(parser.format(date));