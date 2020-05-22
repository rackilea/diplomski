String myDateString = "Fri May 18 00:00:00 EDT 2012";
SimpleDateFormat dateFormat = new SimpleDateFormat();
dateFormat.applyPattern( "EEE MMM dd HH:mm:ss z yyyy" );

try {
    Date d = dateFormat.parse( myDateString );
    System.out.println( d ); // Fri May 18 00:00:00 EDT 2012

    String datePattern1 = "yyyy-MM-dd";
    dateFormat.applyPattern( datePattern1 );
    System.out.println( dateFormat.format( d ) ); // 2012-05-18

    String datePattern2 = "yyyy.MM.dd G 'at' HH:mm:ss z";
    dateFormat.applyPattern( datePattern2 );
    System.out.println( dateFormat.format( d ) ); // 2012.05.18 AD at 00:00:00 EDT

    String datePattern3 = "yyyy.MM.dd G 'at' HH:mm:ss Z";
    dateFormat.applyPattern( datePattern3 );
    System.out.println( dateFormat.format( d ) ); // 2012.05.18 AD at 00:00:00 -400
}
catch ( Exception e ) { // ParseException
    e.printStackTrace();
}