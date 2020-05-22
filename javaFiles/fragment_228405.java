invoicesGrid
        .addColumn(
                new InstantRenderer <>( Invoice :: getWhenCreated ,
                        DateTimeFormatter
                                .ofLocalizedDateTime( FormatStyle.SHORT , FormatStyle.MEDIUM )
                                .withLocale( Locale.CANADA_FRENCH )
                                .withZone( ZoneId.of( "America/Montreal" ) )
                )
        )
        .setHeader( "Created" )
;