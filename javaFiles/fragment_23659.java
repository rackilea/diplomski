public DatabaseTableDay createDay(String name, float weight, Long id) {

    DatabaseTableDay dayToReturn;
    ContentValues values = new ContentValues();
    values.put(DatabaseHelper.COLUMN_DAY_NAME, name);
    values.put(DatabaseHelper.COLUMN_DAY_WEIGHT, weight);
    values.put(DatabaseHelper.COLUMN_DAY_ID, id);

    long resID = mDatabase.insert(DatabaseHelper.TABLE_DAYS, null, values);
    if (resID == -1)
    {
       // something went wrong, do error handling here
       dayToReturn = null;
    }
    else
    {
        // no error: resID is "the row ID of the newly inserted row"
        // you only need this info if you are using autoincrement 
        // not if you set the ID yourself

        // all right, this will work -
        // but somehow it hurts a little to retrieve an entry I just added.
        // I'd like much more to simply use a constructor with all the values 
        // and create a new DatabaseTableDay instance
        dayToReturn = getDayById(id);
    }     

    return dayToReturn;
}