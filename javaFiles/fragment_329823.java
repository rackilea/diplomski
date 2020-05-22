public  void getDatos(){
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor  cursor = database.rawQuery("select * from student",null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex("todo"));

                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
                cursor.moveToNext();
            }
        }
    }