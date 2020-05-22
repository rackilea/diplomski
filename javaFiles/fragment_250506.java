public long createItem(String name, String size, String price, String brand) {

    ContentValues initialValues = new ContentValues();
    String searchValue =     name + " " + 
                            size + " " + 
                            price + " " + 
                            brand;
    initialValues.put(KEY_ITEM, name);
    initialValues.put(KEY_SIZE, size);
    initialValues.put(KEY_PRICE, price);
    initialValues.put(KEY_BRAND, brand);
    initialValues.put(KEY_CATAGORY, catagory);
    initialValues.put(KEY_SEARCH, searchValue);

    return db.insert(FTS_VIRTUAL_TABLE, null, initialValues);
}


public Cursor listAll(){
    String buildSQL = "SELECT * FROM " + ITEM_TABLE_NAME;
    Log.d(TAG, "listAll SQL: " + buildSQL);

    return db.rawQuery(buildSQL, null);
}

    public boolean deleteAllItems() {

    int doneDelete = 0;
    doneDelete = db.delete(FTS_VIRTUAL_TABLE, null , null);
    Log.w(TAG, Integer.toString(doneDelete));
    return doneDelete > 0;

}