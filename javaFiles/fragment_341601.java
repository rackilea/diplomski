public void addScore(String username, int points_to_add) {
    SQLiteDatabase db = this.getWritableDatabase();
    String sql = "UPDATE " + TABLE_USER + " SET " + USER_SCORE + " = " + USER_SCORE + "+? WHERE " + USER_NAME + "=?";
    String[] args = new String[]{String.valueOf(points_to_add), username};
    db.execSQL(sql,args);
    db.close();
}