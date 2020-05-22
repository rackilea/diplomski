List<EventData> getOverlappingEvents(Date startTime, Date endTime) {
    List<EventData> conList = new ArrayList<EventData>();

    String selectQuery = "SELECT  * FROM " + TABLE
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

            event.setId(Integer.parseInt(cursor.getString(0)));
            event.setTitle(cursor.getString(1));
            event.setFromDate(cursor.getString(2));
            event.setToDate(cursor.getString(3));
            event.setLocation(cursor.getString(4));

            conList.add(event);
        } while (cursor.moveToNext());
    }
    return conList;
}