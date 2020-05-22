boolean doesEventOverlap(Date startTime, Date endTime) {
    String selectQuery = "SELECT COUNT(*) FROM " + TABLE
      + " WHERE (" + KEY_FROM_DATE + " < '" + startTime
      + "' AND '" + startTime + "' < " + KEY_TO_DATE + ") OR "
      + " (" + KEY_FROM_DATE + " < '" + endTime
      + "' AND '" + endTime + "' < " + KEY_TO_DATE + ") OR "

      + " (" + KEY_FROM_DATE + " < '" + startTime
      + "' AND '" + endTime + "' < " + KEY_TO_DATE + ") OR "
      + " ('" + startTime + "' < " + KEY_FROM_DATE
      + " AND " + KEY_TO_DATE + " < '" + endTime + "')";

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    if (cursor.moveToFirst()) {
        do {
            EventData event = new EventData();
            return cursor.getInt(0) > 0;
        } while (cursor.moveToNext());
    }
    return false;
}