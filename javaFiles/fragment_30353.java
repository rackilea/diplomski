System.out.println( System.getProperty( "java.version" ) );

ZonedDateTime zdt = ZonedDateTime.parse( "2015-12-03T18:15:30-05:00[America/New_York]" );

DateTimeFormatter formatter =
        DateTimeFormatter
                .ofLocalizedDateTime( FormatStyle.FULL )
                .withLocale( Locale.FRENCH );

System.out.println( formatter.format( zdt ) );