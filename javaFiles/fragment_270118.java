String inputGood = "2015-07-30T09:32:05.543+02:00" ;
String inputBad = "2015-07-35T09:32:05.543+02:00" ;

try{ 
    // Good
    OffsetDateTime odtGood = OffsetDateTime.parse( inputGood ) ;
    System.out.println( "odtGood.toString(): " + odtGood ) ;

    // Bad
    OffsetDateTime odtBad = OffsetDateTime.parse( inputBad ) ;
    System.out.println( "odtBad.toString(): " + odtBad ) ;
} catch ( DateTimeParseException e ) {
    System.out.println( e ) ;
}