Cursor cursor = mDatabase.query(   TABLE_STOP,
                            new String[] { KEY_STOP_LAT, KEY_STOP_LONG },
                            KEY_STOP_NUMBER + "=?",
                            new String[] { <your stop number as string> },
                            null,
                            null,
                            null);

if(cursor.getCount()>0){

    cursor.moveToFirst();

    float stop_lat = cursor.getFloat(0); // first column requested in the second query argument
    float stop_long = cursor.getFloat(1); // second column requested in the second query argument
}

cursor.close();