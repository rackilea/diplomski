public HashMap<String,String> getDetails(String id) {
    HashMap<String, String> hm = new HashMap<>();
    SQLiteDatabase db = getWritableDatabase();
    Cursor c = db.query(TABLENAME, null, "id=?", new String[]{id}, null, null, null);
    if(c.getCount()>0){
      c.moveToFirst();
      hm.put(KEY, c.getString(c.getColumnIndex(COLUMN_NAME)));
    // do this for all columns that you want.
    }
    c.close();
    db.close();
    return hm;
 }