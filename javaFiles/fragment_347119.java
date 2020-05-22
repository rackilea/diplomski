DateTimeZone zoneSaoPaulo = DateTimeZone.forID( "America/Sao_Paulo" );
DateTimeZone zoneNewYork = DateTimeZone.forID( "America/New_York" );
DateTimeZone zoneLosAngeles = DateTimeZone.forID( "America/Los_Angeles" );

Locale locale_ptBR = new Locale( "pt" , "BR" );
Locale locale_enUS = new Locale( "en" , "US" );

DateTimeFormatter formatter_ptBR = DateTimeFormat.forPattern( "dd-MMM-yy" ).withLocale( locale_ptBR ).withZone( zoneSaoPaulo );
DateTimeFormatter formatter_enUS = DateTimeFormat.forPattern( "dd-MMM-yy" ).withLocale( locale_enUS ).withZone( zoneSaoPaulo );  // Try swapping out this time zone to see very different results.

DateTime dateTime_ptBR = formatter_ptBR.parseDateTime( "13-out-14" ).withTimeAtStartOfDay();  // Month must be lowercase for Portuguese, "out" not "Out".
DateTime dateTime_enUS = formatter_enUS.parseDateTime( "13-Oct-14" ).withTimeAtStartOfDay();  // The call to "withTimeAtStartOfDay" is not necessary as it is the default when parsing date-only. I would include it to be self-documenting of our intention.

long millis_ptBR = dateTime_ptBR.getMillis();
long millis_enUS = dateTime_enUS.getMillis();