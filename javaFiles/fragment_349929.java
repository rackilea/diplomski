// Storing
OffsetDateTime odt = zdt.toOffsetDateTime() ;
myPreparedStatement.setObject( … , odt ) ;

// Retrieving
OffsetDateTime odt = myResultSet.getObject( … , OffsetDateTime.class ) ;
ZoneId z = ZoneId.of( "Asia/Kolkata" ) ;
ZonedDateTime zdt = odt.atZone( z ) ;