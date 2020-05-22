@Override
public void onCreate(SQLiteDatabase arg0) {
    // TODO Auto-generated method stub
    arg0.execSQL("CREATE TABLE " + DATABASE_TABLE + " ( "+
                KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                KEY_LEVEL + " TEXT NOT NULL, " +
                KEY_LOCKED + " INTEGER NOT NULL, " +
                KEY_SEQUENCE + " INTEGER NOT NULL, "+
                KEY_TRIES + " INTEGER NOT NULL);");
 }