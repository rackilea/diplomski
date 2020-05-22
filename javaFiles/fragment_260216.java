public Date getLastFriday( int month, int year ) {
   Calendar cal = Calendar.getInstance();
   cal.set( year, month + 1, 1 );
   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 1 ) );
   return cal.getTime();
}