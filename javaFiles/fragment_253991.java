User getUser(String Uid) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_UID,
                        KEY_NAME, KEY_PASS }, KEY_UID + "=?",
                new String[] { Uid }, null, null, null, null);
        if (cursor.moveToFirst()) {
            return new User(cursor.getString(csr.getColumnIndex(KEY_UID),cursor.getString(cursor.getColumnIndex(KEY_NAME)),cursor.getString(cursor.getColumnIndex(KEY_PASS));
        } else
            return null; //I explicitly made this statement to return null in case of no User
    }