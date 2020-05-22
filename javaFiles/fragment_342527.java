DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
value = value.substring(0, value.lastIndexOf('.'));
DateTime datetime = formatter.parseDateTime(value);

// *** create the formatter with the "no-millis" format ***
DateTimeFormatter formatterNoMillis = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
System.out.println("Formatted dateTime: " + datetime.toString(formatterNoMillis));