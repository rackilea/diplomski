public void fillTable(){
    db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(CITY_CODE, "333");
    db.insert(TABLE_NAME, null, values);
    db.close();
    readCity();
}