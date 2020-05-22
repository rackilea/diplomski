Cursor cur = null;
try {

    cur = getContentResolver().query(CallLog.Calls.CONTENT_URI,
            new String[] { BaseColumns._ID, CallLog.Calls.NUMBER, CallLog.Calls.CACHED_NAME, 
            CallLog.Calls.DURATION, CallLog.Calls.DATE, CallLog.Calls.TYPE,  CallLog.Calls.NEW},
            "logtype=100 OR logtype=500", null, "_id");

    displayLogs(cur);

} catch(SQLiteException e){

    cur = getContentResolver().query(CallLog.Calls.CONTENT_URI,
            new String[] { BaseColumns._ID, CallLog.Calls.NUMBER, CallLog.Calls.CACHED_NAME, 
            CallLog.Calls.DURATION, CallLog.Calls.DATE, CallLog.Calls.TYPE,  CallLog.Calls.NEW},
            null, null, "_id");

     displayLogs(cur);

} finally {
    if (cur != null) {
        cur.close();
    }
}