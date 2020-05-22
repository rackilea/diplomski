long startMillis = 0; 
long endMillis = 0;     
Calendar beginTime = Calendar.getInstance();
beginTime.set(2012, 9, 14, 7, 30);
startMillis = beginTime.getTimeInMillis();
Calendar endTime = Calendar.getInstance();
endTime.set(2012, 9, 14, 8, 45);
endMillis = endTime.getTimeInMillis();


// Run query
Cursor cur = null;
ContentResolver cr = getContentResolver();
Uri uri = Events.CONTENT_URI;   

String selection = "((" + Events.DTSTART + " >= ?) AND (" 
                        + Events.DTEND + " <= ?))";
String[] selectionArgs = new String[] {startMillis +"", endMillis +""}; 
// Submit the query and get a Cursor object back. 
cur = cr.query(uri, EVENT_PROJECTION, selection, selectionArgs, null);