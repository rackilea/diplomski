public String savedDate (long id) {
    //Abfrage
    String[] projection = {
            ReminderProvider.COLUMN_ID,
            ReminderProvider.COLUMN_TITLE,
            ReminderProvider.COLUMN_DATE_TIME
    };


    Uri singleUri = ContentUris.withAppendedId(ReminderProvider.CONTENT_URI, mRowID);

    Cursor cursor = getActivity().getContentResolver().query(
            singleUri,
            projection,
            null,
            null,
            null);
    cursor.moveToFirst();

    //Date und Time setzen
    String dateS = cursor.getString(2);

    long dateJavaTimestamp = Long.parseLong(dateS);
    Date date = new Date(dateJavaTimestamp);

    String savedDate = new SimpleDateFormat(DATE_FORMAT).format(date);

    cursor.close();

    return savedDate;
}


public String savedTime (long id) {
    //Abfrage
    String[] projection = {
            ReminderProvider.COLUMN_ID,
            ReminderProvider.COLUMN_TITLE,
            ReminderProvider.COLUMN_DATE_TIME
    };


    Uri singleUri = ContentUris.withAppendedId(ReminderProvider.CONTENT_URI, mRowID);

    Cursor cursor = getActivity().getContentResolver().query(
            singleUri,
            projection,
            null,
            null,
            null);
    cursor.moveToFirst();

    //Date und Time setzen
    String dateS = cursor.getString(2);

    long dateJavaTimestamp = Long.parseLong(dateS);
    Date date = new Date(dateJavaTimestamp);

    String savedTime = new SimpleDateFormat(TIME_FORMAT).format(date);

    cursor.close();

    return savedTime;
}