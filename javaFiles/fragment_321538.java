public int Update(int id) {
    SQLiteDatabase db = this.getWritableDatabase();
 
    ContentValues values = new ContentValues();
    values.put(Note.COLUMN_NOTE, "Yes");
 
    // updating row
    return db.update(Note.TABLE_NAME, values, Note.COLUMN_ID + " = ?",
            new String[]{String.valueOf(id)});