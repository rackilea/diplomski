public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_STUDENTS;//+ " WHERE "+COLUMN_ID+"=1  if you want data for particular id

        //Cursor point to locate data in table
        Cursor c = db.rawQuery(query,null);

       if( c.moveToFirst()){
        do{
            if(c.getString(c.getColumnIndex("_studentname"))!=null){
                dbString += c.getString(c.getColumnIndex("_studentname"));
                dbString += "\n";
            }
        }while (c.moveToNext());
       }
        db.close();
        return dbString;
    }