public int getCandidatesCount() {
    String countQuery = "SELECT  * FROM " + TABLE_CANDIDATES;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    int candidatesCount = cursor.getCount();
    cursor.close();

    // return count
    return candidatesCount;
}