public boolean hasObject(String id) {
    SQLiteDatabase sqdb = getReadableDatabase();

    String selectString = "SELECT * FROM wordsdata WHERE " + Enwd + "=?";

    Cursor cursor = sqdb.rawQuery(selectString, new String[]{id});
    cursor.moveToFirst();

    long count = cursor.getCount();

    boolean hasObject = count > 0;

    //here, count is records found
    Log.d("IS WORD THERE", String.format("%d records found", count));

    cursor.close();        
    db.close();              
    return hasObject;
}