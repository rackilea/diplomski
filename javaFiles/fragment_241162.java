ZoneId zoneId = ZoneId.of ( "America/Montreal" );
LocalDate today = LocalDate.now ( zoneId );

LocalDate yesterday = today.minusDays ( 1 );
LocalDate dayBeforeYesterday = yesterday.minusDays ( 1 );

LocalDate tomorrow = today.plusDays ( 1 );
LocalDate dayAfterTomorrow = tomorrow.plusDays ( 1 );

List<String> days = new ArrayList<> ( 5 );
DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate ( FormatStyle.MEDIUM );
formatter = formatter.withLocale ( Locale.US );  // Or Locale.CANADA, LOCALE.CANADA_FRENCH.
days.add ( dayBeforeYesterday.format ( formatter ) );
days.add ( yesterday.format ( formatter ) );
days.add ( today.format ( formatter ) );
days.add ( tomorrow.format ( formatter ) );
days.add ( dayAfterTomorrow.format ( formatter ) );

System.out.println ( "today: " + today );
System.out.println ( "days: " + days );