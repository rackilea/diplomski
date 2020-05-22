public void insertTableMarital(
        String master_id,
        String anggota,
        String nama,
        String ttl
        ) 
{
    List<String> test= new ArrayList<String>();
String selectQuery = "SELECT master_id,anggota FROM table_marital " +
        "where master_id='"+Menu_SPPAJ.getX()+"'";
SQLiteDatabase db = this.getReadableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);
if(cursor.getCount()>0){
    cursor.moveToPosition(cursor.getCount() - 1);
    if (cursor.moveToFirst()) {
        do {
            test.add(cursor.getString(1));
        } while (cursor.moveToNext());
    } 
        Log.i("TES LAIN", PemegangPolis.getStrAnggota());
    if (!(test.contains(PemegangPolis.getStrAnggota()))){
    ContentValues cv=new ContentValues();
    cv.put("master_id",  master_id);
    cv.put("anggota", anggota);
    cv.put("nama", nama);
    cv.put("ttl", ttl);
    getWritableDatabase().insert("table_marital",null, cv);
    }
    else {
        System.out.println("udah ada");
    }

        }   
else {
    ContentValues cv=new ContentValues();
    cv.put("master_id",  master_id);
    cv.put("anggota", anggota);
    cv.put("nama", nama);
    cv.put("ttl", ttl);
    getWritableDatabase().insert("table_marital",null, cv);
}
}