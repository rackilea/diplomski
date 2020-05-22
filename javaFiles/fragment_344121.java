// this function depends on the values in your cursor
    public void insertCursorInDb(Cursor cursor) {
        if (cursor != null) {
            while (cursor.moveToNext()) {
                ContentValues values = new ContentValues();
                values.put("name", cursor.getString(0));
                values.put("number", cursor.getString(1));
                database.insertOrThrow("contacts", null, values);
            }
            cursor.close();
        }
    }