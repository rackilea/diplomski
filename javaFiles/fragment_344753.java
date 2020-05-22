public Users userLogin(String username) {
    Users users = null;
    SQLiteDatabase db = this.getReadableDatabase();
    //String[] projection = {KEY_USER_ID, KEY_USERNAME, KEY_PASSWORD};
    String selection = KEY_USERNAME + " =?";
    String[] selectionargs = {username};
    Cursor cursor = db.query(TABLE_USERS, null, selection, selectionargs, null, null,null );
    if (cursor.moveToFirst()){

            users = new Users(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getDouble(6),
                    cursor.getDouble(7),
                    cursor.getDouble(8),
                    cursor.getDouble(9),
                    cursor.getDouble(10),
                    cursor.getDouble(11),
                    cursor.getDouble(12),
                    cursor.getDouble(13),
                    cursor.getDouble(14),
                    cursor.getDouble(15),
                    cursor.getDouble(16),
                    cursor.getDouble(17),
                    cursor.getDouble(18),
                    cursor.getDouble(19));
    }
    cursor.close();
    return users;

}