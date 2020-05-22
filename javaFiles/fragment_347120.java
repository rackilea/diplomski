System.out.println( "dateTime_ptBR : " + dateTime_ptBR );
System.out.println( "dateTime_ptBR : " + formatter_ptBR.print( dateTime_ptBR ) );
System.out.println( "dateTime_ptBR : " + DateTimeFormat.forStyle( "FF" ).withLocale( locale_ptBR ).print( dateTime_ptBR ) );
System.out.println( "millis_ptBR : " + millis_ptBR );

System.out.println( "dateTime_enUS : " + dateTime_enUS );
System.out.println( "dateTime_enUS : " + formatter_enUS.print( dateTime_enUS ) );
System.out.println( "dateTime_enUS : " + DateTimeFormat.forStyle( "FF" ).withLocale( locale_enUS ).print( dateTime_enUS ) );
System.out.println( "millis_enUS : " + millis_enUS );

System.out.println( "UTC : " + dateTime_ptBR.withZone( DateTimeZone.UTC ) );