Cursor cursor =  db.rawQuery("select * from " + TABLE_NAME + " where " + COL_5+ "='" + today + "'" , null);
        if (cursor.moveToFirst()) 
         {
            do {
                    // your code like get columns
                }
                 while (cursor.moveToNext());
            }
        }