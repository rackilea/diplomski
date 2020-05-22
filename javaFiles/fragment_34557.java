@Override
public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

    String temptableSQL = "CREATE TABLE IF NOT EXISTS temp_" + TBNAME + "(" +
            "id INTEGER PRIMARY KEY, " +
            "name TEXT," +
            "image_path TEXT" +
            ")";
    if (newversion > oldversion) {
        Log.d("DBINFO","onUpgrade Started.");
        db.execSQL(temptableSQL);

        Cursor olddata = db.query(TBNAME,null,null,null,null,null,null);
        CommonSQLiteUtilities.logCursorData(olddata); //<<<<
        olddata.moveToPosition(-1); //<<<<<

        //db.execSQL(tableSQL);
        Log.d("DBINFO","Databse info in onUpgrade after creation of new table1.");
        CommonSQLiteUtilities.logDatabaseInfo(db); //<<<<<
        Log.d("DBCOPYDATA",
                "Copying data from OLD Data. # rows = " +  
                        Integer.toString(olddata.getCount())
        ); //<<<<<
        while (olddata.moveToNext()) {
            ContentValues cv = new ContentValues();
            Log.d("DBCOPYDATA","ROW " + Integer.toString(olddata.getPosition()) +
                    "\n\tID=" + Long.toString(olddata.getLong(olddata.getColumnIndex("id"))) +
                    "\n\tNAME=" + olddata.getString(olddata.getColumnIndex("name")) +
                    "\n\tIMG =" + olddata.getString(olddata.getColumnIndex("image_byte"))
            ); //<<<<<
            cv.put("id",Long.toString(olddata.getLong(olddata.getColumnIndex("id"))));
            cv.put("name",olddata.getString(olddata.getColumnIndex("name")));
            cv.put("image_path",olddata.getString(olddata.getColumnIndex("image_byte")));

            Long id = db.insert("temp_" + TBNAME,null,cv);
            Log.d("DBCOPYDATA","INSERTED ID=" + Long.toString(id)); //<<<<<

        }
        olddata.close();
        db.execSQL("DROP TABLE IF EXISTS " + TBNAME);
        db.execSQL("ALTER TABLE temp_" + TBNAME + " RENAME TO " + TBNAME);

        Cursor csr = db.query(TBNAME,null,null,null,null,null,null); //<<<<<
        CommonSQLiteUtilities.logDatabaseInfo(db); //<<<<<
        CommonSQLiteUtilities.logCursorData(csr); //<<<<<
        csr.close(); //<<<<<
    }
}