public long insert_data(String username, String password, String confirm_password) // Signature changed to return long (id)
{
    ContentValues contentValues = new ContentValues();
    contentValues.put(DatabaseHelper.COL2, username);
    contentValues.put(DatabaseHelper.COL3, password);
    contentValues.put(DatabaseHelper.COL4, confirm_password);
    long id=db1.insert(DatabaseHelper.TABLENAME, null, contentValues);
    //TODO REMOVE LOGGING BEFORE PUBLISHING THE APP
    if (id > 0) {
        Log.d("INSERTUSERDETAILSROW","The row was successfully inserted into the " + DatabaseHelper.TABLENAME + " table.");
    } else {
        Log.d("INSERTUSERDETAILSROW","Row not inserted!!!!!!!!!!");
    }
    return id; // Can be useful to have access to the id that was generated. Note method signature change 
}