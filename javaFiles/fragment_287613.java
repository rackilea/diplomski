public long insertTimeSheet(String name)
{
    database=dbHelper.getWritableDatabase();
    ContentValues values=new ContentValues();
    values.put(MyDatabaseHelper.Name,name);
    database.insert(MyDatabaseHelper.TABLE_INFO,null,values);
    Cursor cursor = database.rawQuery("SELECT MAX(ID) FROM Table_Info", null);
    database.close();
    return cursor.getLong(0) ;
}