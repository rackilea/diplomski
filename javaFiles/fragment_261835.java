db = dbh.getWritableDatabase();
try {
    long score = DatabaseUtils.longForQuery(db,
                "SELECT Score FROM MyTable WHERE MarkerID = ?",
                new String[]{ markerID });
    if (score < 0) { // not found?
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_MARKERID, markerID);
        cv.put(COLUMN_SCORE, ...);
        db.insertOrThrow(SCORE_TABLE, null, cv);
    } else if (score < 5) {
        // nothing
    } else {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SCORE, ...);
        db.update(SCORE_TABLE, cv,
                  "MarkerID = ?", new String[]{ markerID });
    }
} finally {
    db.close();
}