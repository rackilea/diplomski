public void isActive(int id, boolean isActive) 
{
    int is_active = (isActive) ? 1 : 0;

    SQLiteDatabase db = this.getWritableDatabase();    
    try {
        ContentValues cv = new ContentValues();
        cv.put(IS_ACTIVE, is_active);

        // The columns for the WHERE clause
        String selection = (ID+ " = ?");

        // The values for the WHERE clause
        String[] selectionArgs = {id};

        db.update(TABLE_NAME, cv, selection, selectionArgs);
    } 
    catch (Exception e) {
        e.printStackTrace();
    }
}