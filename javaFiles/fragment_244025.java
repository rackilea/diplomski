String query = " CREATE TABLE " + table_name + " ("
    + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
    + column_desc + " TEXT,"
    + column_loc + " TEXT,"
    + column_strt + " TEXT,"
    + column_fnsh + " TEXT,"
    + column_comm + " TEXT" + ");";
    sqLiteDatabase.execSQL(query);
}