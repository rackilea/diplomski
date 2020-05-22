SQLiteDatabase sqLiteDatabase = getWritableDatabase();

   Cursor cursor = sqLiteDatabase .rawQuery("select * from [table-name] ");
    if (cursor.moveToFirst()) {
         do {

    String intentDescription = cursor.getString(0); // getting intent from         sqlite at index 0   
        Intent intent = Intent.parseUri(intentDescription, 0);


         } while (cursor.moveToNext());
      }
      if (cursor != null && !cursor.isClosed()) {
         cursor.close();
      }
      if(db!=null)
      {
          db.close();
      }