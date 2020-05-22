public int getRowCount() throws Exception {
    SQLiteDatabase db = this.getWritableDatabase();


    Cursor mCount= db.rawQuery("SELECT COUNT (*) FROM " + TABLE_PRODUCTS,
    null); 

    mCount.moveToFirst();
    int rows= mCount.getInt(0);
    mCount.close();

return rows;

 }