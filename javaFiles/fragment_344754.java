public Users userLogin(String username) {
    Users users = null;
    SQLiteDatabase db = this.getReadableDatabase();
    String[] projection = {KEY_USER_ID, KEY_USERNAME, KEY_PASSWORD};
    String selection = KEY_USERNAME + " =?";
    String[] selectionargs = {username};
    Cursor cursor = db.query(TABLE_USERS, projection, selection, selectionargs, null, null,null );
    if (cursor.moveToFirst()){

            users = new Users(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2))
    }
    cursor.close();
    return users;

}