@Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DB_CREATE);

        database.execSQL("INSERT INTO "+ TABLE_NAME  + " VALUES(null, 'Click me to edit');");
        database.execSQL("INSERT INTO "+ TABLE_NAME  + " VALUES(null, 'Swipe me to erase');");

    }