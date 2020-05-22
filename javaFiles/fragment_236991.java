ZoneId z = ZoneId.of( "Africa/Tunis" ) ;
LocalDate ld = LocalDate.of( 2018 , Month.JANUARY , 23 ) ;  // 2018-01-23
LocalTime lt = LocalTime.of( 8 , 0 ) ; // 8 AM.
Instant instant = ZonedDateTime.of( ld , lt , z ).toInstant() ;
Clock c = Clock.fixed( instant , z ) ;
AcademicYear ay = AcademicYear.now( c ) ;