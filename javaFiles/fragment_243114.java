SQLiteDatabase db = this.getReadableDatabase();
Cursor res = db.rawQuery("SELECT * FROM user_tbl WHERE username = '" + username + "'", null);

if(res.getCount() > 0){
  res.moveToFirst();
  String fullnamee = res.getString(res.getColumnIndex(DBHelper.USER_NAME));
  // do what you want
}