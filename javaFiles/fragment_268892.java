// getData method
public ArrayList<ArrayList<String>> getData() {
    SQLiteDatabase db=this.getWritableDatabase();
    String[] columns = new String[]{COL_1, COL_2};
    Cursor c = ourDatabase.query(TABLE_NAME, columns, null, null, null, null, null);

    int rowId = c.getColumnIndex(COL_1);
    int text = c.getColumnIndex(COL_2);

    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(c.getString(rowId));
        temp.add(c.getString(text));
        data.add(temp);
    }

    return data;
}

// deleteEntry method
public boolean deleteEntry(long row) {
    SQLiteDatabase db=this.getWritableDatabase();
    db.delete(TABLE_NAME, COL_1 + "=" + row, null);
    return true;
}