String input2017 = "2017-01-30T13:00:00+0000".replace( "+0000" , "+00:00" ) ;  // Workaround Java 8 bug where omitted colon in offset-from-UTC fails to parse. Fixed in Java 9.
OffsetDateTime odt2017 = OffsetDateTime.parse( input2017 ) ; 

String input2018 = "2018-06-23T16:00:00+0000".replace( "+0000" , "+00:00" ) ;  // Workaround Java 8 bug where omitted colon in offset-from-UTC fails to parse. Fixed in Java 9.
OffsetDateTime odt2018 = OffsetDateTime.parse( input2018 ) ; 

ZoneId z = ZoneId.of( "Europe/London" ) ; 
ZonedDateTime zdt2017 = odt2017.atZoneSameInstant( z ) ;
ZonedDateTime zdt2018 = odt2018.atZoneSameInstant( z ) ;