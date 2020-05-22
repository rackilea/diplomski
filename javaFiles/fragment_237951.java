Cursor cursor = null;
SQLiteDatabase db = null;
try {
     File dbfile = getApplicationContext().getDatabasePath(f.getPath());
     dbfile.setWritable(true);
     db = SQLiteDatabase.openDatabase(dbfile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);

     String sql = "SELECT value FROM ItemTable WHERE key='fav_list'";
     cursor = db.rawQuery(sql, null);
     cursor.moveToFirst();
      while (!cursor.isAfterLast()) {

            byte[] itemByteArray = cursor.getBlob(0);
            String itemString = new String(itemByteArray, Charset.forName("UTF-16LE"));
            cursor.moveToNext();
            }
    } catch (IOException e) {
        e.printStackTrace();
      } finally {

        if (cursor != null) {
            cursor.close();
        }
        if (db != null) {
            db.close();
        }
    }