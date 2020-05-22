// Add a new set of values to the database, unless the name already exists.
public long insertRow(String name, int studentNum, String favColour) {
    Cursor c =  db.query(true, DATABASE_TABLE, ALL_KEYS, 
                    KEY_NAME + "='" + name + "'", null, null, null, null, null);
    if (c.getCount() > 0) {
        return -1;
    }
    c.close();

    /*
     * CHANGE 3:
     */     
    // TODO: Update data in the row with new fields.
    // TODO: Also change the function's arguments to be what you need!
    // Create row's data:
    ContentValues initialValues = new ContentValues();
    initialValues.put(KEY_NAME, name);
    initialValues.put(KEY_STUDENTNUM, studentNum);
    initialValues.put(KEY_FAVCOLOUR, favColour);

    // Insert it into the database.
    return db.insert(DATABASE_TABLE, null, initialValues);
}