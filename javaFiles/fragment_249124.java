@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE todos (_id INTEGER PRIMARY KEY, todo TEXT, status INTEGER, created_at INTEGER);");
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.e(getClass().getSimpleName(), "onUpgrade: this is  not required.");
}