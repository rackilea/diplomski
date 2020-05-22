mContext = this;

    // Create the database directory if it doesn't exist 
    File dbpath = mContext.getDatabasePath("fieldgames");
    if (!dbpath.getParentFile().exists()) {
        dbpath.getParentFile().mkdirs();
    }
    SQLiteDatabase fieldgameDB = SQLiteDatabase.openOrCreateDatabase(dbpath,null);
    fieldgameDB.execSQL("CREATE TABLE IF NOT EXISTS assignments(title VARCHAR,description VARCHAR,assignmentId INT, created_at TIMESTAMP);");
    fieldgameDB.execSQL("INSERT INTO assignments VALUES('title', 'description',1, 'created_at')");
    Cursor cursor;
    cursor = (Cursor) fieldgameDB.rawQuery("SELECT * FROM assignments", null);
    cursor.moveToFirst();
    DatabaseUtils.dumpCursor(cursor);
    System.out.print(cursor.getString(cursor.getColumnIndex("description")));
    cursor.close();