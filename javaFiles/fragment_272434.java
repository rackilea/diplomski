private static class DatabaseHelper extends SQLiteOpenHelper{

    DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // increased version
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         // Either add the column, or drop and create the table again. 
    }

}