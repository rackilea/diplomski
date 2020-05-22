Locale locale_ptBR = new Locale( "pt" , "BR" );  // Portuguese in Brazil.
System.out.println( "Short months for locale : " + locale_ptBR + Arrays.toString( org.joda.time.DateTimeUtils.getDateFormatSymbols( locale_ptBR ).getShortMonths() ) );

Locale locale_frCA = Locale.CANADA_FRENCH;  // Québec.
System.out.println( "Short months for locale : " + locale_frCA + Arrays.toString( org.joda.time.DateTimeUtils.getDateFormatSymbols( locale_frCA ).getShortMonths() ) );

Locale locale_enUS = Locale.US;  // United States.
System.out.println( "Short months for locale : " + locale_enUS + Arrays.toString( org.joda.time.DateTimeUtils.getDateFormatSymbols( locale_enUS ).getShortMonths() ) );