SQLiteDatabase db = this.getWritableDatabase();
    String get_VALUE = "";
    String last_query = "SELECT DIA FROM " + TABLE_TESTES + " WHERE " + ID + " = '" + id+ "'";
    Cursor c = db.rawQuery(last_query, null);
    if (c != null && c.moveToFirst()) 
    {
        get_VALUE = c.getString(c.getColumnIndex("DIA"));
    }
    db.close();
    return get_VALUE;