String input = "Wed Jan 20 15:13:09 EET 2016";
SimpleDateFormat formatter = new SimpleDateFormat ( "EEE MMM dd HH:mm:ss zzz yyyy" );
Date date = null;
try {
    date = formatter.parse ( input );
} catch ( ParseException e ) {
    System.out.println ( "Exception… " + e );
}

System.out.println ( "date: " + date + " | date via formatter: " + formatter.format ( date ) + " | as Instant: " + date.toInstant () );