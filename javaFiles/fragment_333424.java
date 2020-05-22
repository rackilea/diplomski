try {
    LocalDateTime ldt = LocalDateTime.parse( input );
} catch (DateTimeParseException e ) {
    // Handle this error, when we receive faulty input.
    System.out.println( "Wrong input." ); 
}