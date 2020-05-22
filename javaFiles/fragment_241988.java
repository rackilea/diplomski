String str = "Thu May 31 01:43:45 GMT-8 2018";

DateTimeFormatter formatter = 
                  DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss O yyyy", Locale.ENGLISH);

ZonedDateTime date = ZonedDateTime.parse(str, formatter);
System.out.println(date.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)); 
// 2018-05-31T01:43:45-08:00