java.sql.Timestamp ts2013 = Timestamp.valueOf ( "2013-12-28 00:00:00.0" );
java.sql.Timestamp ts2014 = Timestamp.valueOf ( "2014-12-28 00:00:00.0" );
java.sql.Timestamp ts2015 = Timestamp.valueOf ( "2015-12-28 00:00:00.0" );

Calendar cal2013 = Calendar.getInstance ( );
cal2013.setTime ( new java.util.Date ( ts2013.getTime ( ) ) );
cal2013.add ( Calendar.DAY_OF_MONTH, 7 );
java.sql.Timestamp ts2013Plus = new Timestamp ( cal2013.getTime ( ).getTime ( ) );
System.out.println ( ts2013 + " + 7 = " + ts2013Plus );

Calendar cal2014 = Calendar.getInstance ( );
cal2014.setTime ( new java.util.Date ( ts2014.getTime ( ) ) );
cal2014.add ( Calendar.DAY_OF_MONTH, 7 );
java.sql.Timestamp ts2014Plus = new Timestamp ( cal2014.getTime ( ).getTime ( ) );
System.out.println ( ts2014 + " + 7 = " + ts2014Plus );

Calendar cal2015 = Calendar.getInstance ( );
cal2015.setTime ( new java.util.Date ( ts2015.getTime ( ) ) );
cal2015.add ( Calendar.DAY_OF_MONTH, 7 );
java.sql.Timestamp ts2015Plus = new Timestamp ( cal2015.getTime ( ).getTime ( ) );
System.out.println ( ts2015 + " + 7 = " + ts2015Plus );