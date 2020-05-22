private void dbCreateUser(SQLiteDatabase db)
{
    SQL_CREATE_USER = "CREATE TABLE " + UserContract.TABLE_NAME + " (";
    SQL_CREATE_USER += UserContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,";
    SQL_CREATE_USER += UserContract. COLUMN_NAME_USER_JSONOBJECT+ TEXT_TYPE;
    SQL_CREATE_USER += " )";
}