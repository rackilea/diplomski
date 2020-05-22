SQLiteDatabase db = myDbHelper.getReadableDatabase();
ContentValues values = new ContentValues();

db.beginTransaction(); 

try{
    int bit = 1;

    for (String value: valuearray) {
        values.put("value", value);
        db.update("registro_status", values, "bit=" +bit++, null);
    }

    db.setTransactionSuccessful();

} catch(Exception e) {
    Log.e(“Error in transaction”, e.toString());

} finally {
    db.endTransaction();
}