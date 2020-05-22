@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // delete our old table
    db.execSQL("DROP TABLE IF EXISTS " + tableName);

    // create our new table
    onCreate(db);
}