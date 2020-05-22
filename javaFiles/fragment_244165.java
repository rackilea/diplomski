String tableName = ""; // your table name
Cursor c = db.rawQuery("PRAGMA table_info(" + tableName + ")", null);
if (c.moveToFirst()) {
    do {
        System.out.println("name: " + c.getString(1) + " type: " + c.getString(2));
    } while (c.moveToNext());
}
c.close();