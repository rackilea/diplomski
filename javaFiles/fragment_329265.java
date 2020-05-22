@Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
        db.execSQL(CREATE_TABLE_3);
        db.execSQL("insert into " + DATABASE_TABLE3 + "(" + KEY_ROWID + ","
                + KEY_DEF + ") values(1,'')");
    }