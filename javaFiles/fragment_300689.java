public static Date getLastSunday( int month, int year ) {
       Calendar cal = Calendar.getInstance();
       cal.set( year, month + 1, 1 );
       cal.add(Calendar.DATE, -1); 
   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) - 1 ) );
       return cal.getTime();
    }