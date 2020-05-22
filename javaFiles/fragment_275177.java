public void storeResults(String name, List<EarSrt> leftAnswerList, List<EarSrt> rightAnswerList){
    SQLiteDatabase db = getWritableDatabase(); // opens the database connection
    try {
        ContentValues values = new ContentValues();
        values.put(SAVED_NAME, name);
        Long now = Long.valueOf(System.currentTimeMillis());
        values.put(COLUMN_NAME_CREATE_DATE, now);
        values.put(RIGHT_EAR, serializeObject(rightAnswerList ));
        values.put(LEFT_EAR, serializeObject(leftAnswerList ));
        db.insert(TABLE_NAME, null, values);
    }
    catch(Exception e) {
        e.printStackTrace();
        // furher error handling
    }
    finally {
        db.close(); // closes the database every time after access
    }
}