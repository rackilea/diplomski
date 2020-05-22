public int getDBPlacesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_DB_VERLADESTELLEN_Eintrag;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count
    }