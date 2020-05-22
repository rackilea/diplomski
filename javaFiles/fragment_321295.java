ZoneId z = ZoneId.of( "America/Montreal" );
LocalDate today = LocalDate.now( z );

LocalDate firstOfMonth = today.with( TemporalAdjusters.firstDayOfMonth() );
LocalDate monday = firstOfMonth.with( TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY ) );

LocalDate endOfMonth = today.with( TemporalAdjusters.lastDayOfMonth() );
LocalDate sunday = endOfMonth.with( TemporalAdjusters.nextOrSame( DayOfWeek.SUNDAY ) );