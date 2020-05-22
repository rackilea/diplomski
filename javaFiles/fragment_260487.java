// Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_LOCATIONLABLES = "CREATE TABLE " + TABLE_LOCATIONLABLES + "("
                + KEY_LOCID + " INTEGER PRIMARY KEY," + KEY_LOCNAME + " TEXT,"
                +  ")";
        db.execSQL(TABLE_LOCATIONLABLES);   
    }