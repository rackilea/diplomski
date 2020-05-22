String rowId; //Set your row id here
SQLiteDatabase sqLiteDatabase = mHelper.getWritableDatabase();
sqLiteDatabase.delete(
                TaskContract.TaskEntry.TABLE,  // Where to delete
                KEY_ID+" = ?",  
                new String[]{rowId});  // What to delete
sqLiteDatabase.close();