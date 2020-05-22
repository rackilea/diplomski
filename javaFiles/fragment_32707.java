public void saveDataRecord(TheModelClass blablabla) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(CATEGORY_COLUMN_ID, blablabla.getId());
    contentValues.put(CATEGORY_COLUMN_NAME, blablalbla.getName());
    database.insert(TABLE_NAME, null, contentValues);
}