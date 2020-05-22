List<LocalDate> localDates = new ArrayList<> ( 3 );
LocalDate today = LocalDate.now ( ZoneId.of ( "America/Montreal" ) );
localDates.add ( today );
localDates.add ( today.plusDays ( 2 ) );
localDates.add ( today.minusDays ( 4 ) );

LocalDate max = Collections.max ( localDates );