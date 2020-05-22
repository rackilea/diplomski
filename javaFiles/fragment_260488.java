@Override
    public void onCreate(SQLiteDatabase db) {
        String mQuery = "CREATE TABLE " + TABLE_LOCATIONLABLES + "("
                + KEY_LOCID + " INTEGER PRIMARY KEY," + KEY_LOCNAME + " TEXT,"
                +  ")";
        db.execSQL(mQuery);   
    }