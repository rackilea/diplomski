@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    switch(oldVersion){
        case 1:
            db.execSQL("ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN " + NEW_COLUMN_NAME + TYPE);
    }
}