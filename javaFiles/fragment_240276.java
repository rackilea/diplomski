String input = "Mon Jan 01 00:00:00 AEDT 1990";
Locale locale = Locale.US;
DateTimeFormatter f = DateTimeFormatter.ofPattern( "EEE MMM dd HH:mm:ss z uuuu" , locale );
ZonedDateTime zdt = ZonedDateTime.parse( input , f );

System.out.println( "zdt: " + zdt );