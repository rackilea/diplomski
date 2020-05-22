public static long getNewEventId(ContentResolver cr, Uri cal_uri){      
    Uri local_uri = cal_uri;
    if(cal_uri == null){
        local_uri = Uri.parse(calendar_uri+"events");
    } 
    Cursor cursor = cr.query(local_uri, new String [] {"MAX(_id) as max_id"}, null, null, "_id");
    cursor.moveToFirst();
    long max_val = cursor.getLong(cursor.getColumnIndex("max_id"));     
    return max_val+1;
}