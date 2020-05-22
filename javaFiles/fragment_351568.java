public void insertDomainEntry(Date exp_date, String name, long event_id){
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("exp_date", exp_date.getTime()/1000);
    values.put("event_id", event_id);
    values.put("domainname", name);
    db.insertOrThrow("domains_events", null, values);
}