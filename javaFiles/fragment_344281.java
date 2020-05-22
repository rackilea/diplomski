String date = "Sat Dec 01 20:56:28 CET 2018";
DateTimeFormatter formatter = 
    DateTimeFormatter.ofPattern(
        "EEE MMM dd HH:mm:ss z uuuu" , 
        Locale.US 
    )
;

ZonedDateTime dateTime = ZonedDateTime.parse(date, formatter);
System.out.println(dateTime);