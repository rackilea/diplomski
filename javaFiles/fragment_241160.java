Calendar cal = Calendar.getInstance ();
DateFormat dateFormat1 = new SimpleDateFormat ( "EEEE, MMM dd, yyyy" , Locale.getDefault () );
System.out.println ( "cal: " + dateFormat1.format ( cal.getTime () ) );

for ( int j = 0 ; j < 2 ; j ++ ) {
    cal.add ( Calendar.DAY_OF_MONTH , -1 );
    String yest = dateFormat1.format ( cal.getTime () );
    System.out.println ( "yest: " + yest );
}

String todate = dateFormat1.format ( cal.getTime () );
System.out.println ( "todate: " + todate );

for ( int i = 0 ; i < 2 ; i ++ ) {
    cal.add ( Calendar.DATE , 1 );
    String tomo = dateFormat1.format ( cal.getTime () );
    System.out.println ( "tomo: " + tomo );
}