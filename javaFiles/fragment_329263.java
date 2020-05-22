public Cursor readBook(String book) {

      SQLiteDatabase db = this.getWritableDatabase();
      String sql = "select * from " + TABLE_NAME+ " 
                    where " + COL_ID + " = '" + book + "';";

      return db.rawQuery(sql,null);
}