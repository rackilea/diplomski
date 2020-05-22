// Parse input string.
String input = "29.12.2014";
DateTimeFormatter formatter = DateTimeFormat.forPattern( "dd.MM.yyyy" );
LocalDate inputLocalDate = formatter.parseLocalDate( input );

// Find desired Monday.
LocalDate possibleMonday = inputLocalDate.withDayOfWeek( DateTimeConstants.MONDAY ); 

// The possible Monday could be past, present, or future of our input date. Adjust as needed.
LocalDate desiredMonday = null;
if ( possibleMonday.isBefore( inputLocalDate ) || possibleMonday.isEqual( inputLocalDate ) ) {
    desiredMonday = possibleMonday.plusWeeks( 1 ); // If the possible Monday is past or present, add a week to get *next* Monday.
} else {
    desiredMonday = possibleMonday;  // If the possible Monday is future, use it.
}

String output = formatter.print( desiredMonday );