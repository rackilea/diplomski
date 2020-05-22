public List<Expense> getSepficItem() {
    List<Expense> result = new ArrayList();
    // Select All Query
    SQLiteDatabase db = this.getReadableDatabase();
    String q = "SELECT * FROM Expense";
    Cursor mCursor = db.rawQuery(q, null);
    if (cursor.moveToFirst()) {
        do {
            Expense expense = new Expense();
            expense.setId(Integer.parseInt(cursor.getString(0)));
            // etc...
            expense.setType(cursor.getString(2));
            // etc...
            result.add(contact);
        } while (cursor.moveToNext());
    }
    mCursor.close();
    db.close();
    return result;
}