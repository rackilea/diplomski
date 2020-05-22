public String[] getSongIds(String whereClause) throws FetchSongException {
  String countQuery = "SELECT  songid FROM TABLE_INDEX WHERE " + whereClause;
  try {
    Cursor cursor = db.rawQuery(countQuery, null);
    int cursorSize = cursor.getCount();

    int[] songIds = new int[cursorSize];
    int count=0;
    if (cursor != null) {
      if (cursor.moveToFirst()) {
        do {
          songIds[count] = cursor.getInt(cursor.getColumnIndex("songid"));
          count++;
        } while(cursor.moveToNext());
      }
      cursor.close(); // you should put this in a finally block
      db.close();
      return getSongTitles(songIds);
    }
  } catch (SQLException sqle) {
    throw new FetchSongException("Unable to fetch song ids.", sqle);
  }
}