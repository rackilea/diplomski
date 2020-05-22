String input = "2017-02-45" ;
System.out.println( "input: " + input ) ;

for( ResolverStyle rs : ResolverStyle.values() ) 
{
    try{
        System.out.println( "---------------" ) ;
        System.out.println( "Parsing with ResolverStyle: " + rs ) ;
        DateTimeFormatter f = DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle( rs ) ;
        LocalDate ld = LocalDate.parse( input , f ) ;
        System.out.println( "ld.toString(): " + ld ) ;
    } catch ( DateTimeParseException e ) {
        System.out.println( "Caught exception for ResolverStyle: " + rs ) ;
    }

}