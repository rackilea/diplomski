public void addScore(String username, int point){ //<<<<<<<<<< Changed signature
    SQLiteDatabase db = this.getWritableDatabase();
    String whereclause = USER_NAME + "=?"; //<<<<<<<<<< Added
    String[] whereargs = new String[]{username}; //<<<<<<<<<< Added
    ContentValues values = new ContentValues();
    values.put(USER_SCORE, point);
    // Inserting Row
    db.update(TABLE_USER, values, whereclause, whereargs);
    db.close();
}