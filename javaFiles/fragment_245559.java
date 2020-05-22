public int InsertAPN() throws SecurityException {

    int id = -1;
    if (i < nameArr.size()) {
        for (i = 0; i < nameArr.size(); i++) {
            ContentValues values2 = new ContentValues();

            values2 = getValues();