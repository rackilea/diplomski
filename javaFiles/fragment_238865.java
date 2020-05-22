public int getAllEntries() {
    //int entryCount;
    Cursor cursorE = db.rawQuery("SELECT COUNT(LATS) FROM myPROmapData",
            null);
    try {
      if (cursorE.moveToFirst()) {
          return cursorE.getInt(0);
      }   
      return cursorE.getInt(0);
    } finally {
      cursorE.close();
    }
}