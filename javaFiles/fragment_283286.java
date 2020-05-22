Instant instant = 
    OffsetDateTime.of( LocalDate.of( 2016 , 1 , 2 ) , 
                       LocalTime.of( 12 , 34 , 56 ) , 
                       ZoneOffset.ofHours( -3 ) 
                     )
                  .toInstant() ;