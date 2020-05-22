public void create(ListItem item) {
    // SQLiteDatabase database = open();
    database.beginTransaction();

    ContentValues contentValues = new ContentValues();
    contentValues.put(EasyListSQLiteHelper.LISTS_NAME, item.getListName());
    contentValues.put(EasyListSQLiteHelper.LISTS_CHECKED, item.getImportant());
    database.insert(EasyListSQLiteHelper.LISTS_TABLE, null, contentValues);

    database.setTransactionSuccessful();
    database.endTransaction();
    database.close();
    close(database);
}