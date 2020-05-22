public ArrayList<Listcollection> listfromdb() {
    SQLiteDatabase db = this.getReadableDatabase();
    ArrayList<Listcollection> results = new ArrayList<Listcollection>();

    Cursor crs = db.rawQuery("select * from contacts", null);
    while (crs.moveToNext()) {
        Listcollection item = new Listcollection();
        item.setId(crs.getInt(crs.getColumnIndex(CONTACTS_COLUMN_ID)));
        item.setName(crs.getString(crs.getColumnIndex(C_NAME)));
        item.setDate(crs.getString(crs.getColumnIndex(C_DATE)));
        list.setPhone(crs.getString(crs.getColumnIndex(C_PHONE)));
        results.add(item);
    }

    db.close();
    return results;
}