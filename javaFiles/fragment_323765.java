@Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + TABLE_NAME + "create table LMSLiteDB(ID text primary key not null," +
                "Password text not null, Name text not null, VU-Email text not null, City text not null," +
                "Country text not null, Selected_Course text not null);");

    }