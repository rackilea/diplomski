System.out.println( System.getProperty( "java.version" ) );
System.out.println( Locale.getDefault().toString() );

LocalDate ld = LocalDate.of( 2018 , Month.AUGUST , 30 );

Locale locale = Locale.US;
DateTimeFormatter f = DateTimeFormatter.ofPattern( "E d MMM yyyy" , locale );
String output = ld.format( f );

System.out.println( output );