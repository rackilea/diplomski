public List<String> getImagePath()
{
    ArrayList<String> paths = new ArrayList<String>();
    String selectQuery = "SELECT * FROM " + TABLE_PATH;
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {

            paths.add(cursor.getString(0).toString());
            Log.d("getPathImage:", cursor.getString(0).toString());
        } while (cursor.moveToNext());
    }

     return paths;
}