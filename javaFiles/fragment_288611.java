LocalDate ld = 
    LocalDate.ofEpochDay( 
        ChronoField.EPOCH_DAY.range().getMinimum() 
    )
;
System.out.println( ld );