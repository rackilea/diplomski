public static final DateTimeZone EST = DateTimeZone.forID("EST");
public static final DateTimeZone EASTERN = DateTimeZone.forID("US/Eastern");
public static final DateTimeFormatter EST_FORMATTER = 
  DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS").withZone(EST);

// in your parsing method...
String input = "2014-03-09 02:00:00.000";
DateTime dt = EST_FORMATTER.parseDateTime(input);
System.out.println(dt); // 2014-03-09T02:00:00.000-05:00
System.out.println(dt.withZone(EASTERN)); // 2014-03-09T03:00:00.000-04:00