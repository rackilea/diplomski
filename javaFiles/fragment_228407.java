invoicesGrid
        .addColumn(
                new InstantRenderer <>( Invoice :: getWhenCreated ,
                        f
                                .withLocale( user.getPreferredLocale()  )
                                .withZone( user.getPreferredZone() )
                )
        )
        .setHeader( "Created" )
;