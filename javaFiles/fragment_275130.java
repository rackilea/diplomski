String input = "Mon, 13 Mar 2017 19:00:10 +0530 (IST)";
int index = input.indexOf ( " (" ); // Searching for SPACE + LEFT PARENTHESIS.
String inputModified = input.substring ( 0 , index ); // "Mon, 13 Mar 2017 19:00:10 +0530"

Instant instant = 
    OffsetDateTime.parse ( 
        inputModified , 
        DateTimeFormatter.ofPattern( "EEE, d MMM uuuu HH:mm:ss Z" ) 
    ).toInstant() 
;