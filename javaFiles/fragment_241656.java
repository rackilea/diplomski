public int getExerciseID(String exercise, String bodyPart) {
        int exerciseID = 0;
        SQLiteDatabase db = myDBHelper.getWritableDatabase();

        String query = "SELECT " + myDBHelper.COLUMN_ID + " FROM " + myDBHelper.TABLE_EXERCISES + " WHERE " +
                myDBHelper.COLUMN_BODYPARTNAME + " = " + bodyPart + " AND " +
                myDBHelper.COLUMN_EXERCISENAME + " = " + exercise ;

        Cursor c = db.rawQuery(query, null);
        if(c.getCount()>0){
          c.moveToFirst();
          exerciseID = Integer.parseInt(c.getString(0));
          /*exerciseID = c.getInt(c.getColumnIndex(myDBHelper.COLUMN_ID));*/
        }
        c.close();
        db.close();

        return exerciseID;
    }