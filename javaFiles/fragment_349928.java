// Storing
OffsetDateTime odt = instant.atOffset( ZoneOffset.UTC ) ;
myPreparedStatement.setObject( … , odt ) ;

// Retrieving
OffsetDateTime odt = myResultSet.getObject( … , OffsetDateTime.class ) ;
Instant instant = odt.toInstant() ;