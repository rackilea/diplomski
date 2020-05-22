private Cursor getEventInstancesCursor() { // Query for a list of GQueues Calendar instances today

    // Set Calendar variable for start and end of today.
    Calendar startOfDay = Calendar.getInstance();
    int thisYear = startOfDay.get(Calendar.YEAR);
    int thisMonth = startOfDay.get(Calendar.MONTH);
    int thisDay = startOfDay.get(Calendar.DAY_OF_MONTH);
    startOfDay.set(thisYear, thisMonth, thisDay, 0, 0, 0);
    long startMillis = startOfDay.getTimeInMillis();
    Calendar endOfDay = Calendar.getInstance();
    endOfDay.set(thisYear, thisMonth, thisDay, 23, 59, 59);
    long endMillis = endOfDay.getTimeInMillis();

    long GQueuesCalID = getGQueuesCalID();
    Cursor eventsCursor = null;
    ContentResolver eventsCR = getContentResolver();

    String selection = CalendarContract.Instances.CALENDAR_ID + " = ?";
    String calIDString = String.valueOf(GQueuesCalID);
    String[] selectionArgs = {calIDString};

    try {
        return eventsCursor = eventsCR.query(
                CalendarContract.Instances.CONTENT_URI.buildUpon()
                        .appendPath(Long.toString(startMillis))
                        .appendPath(Long.toString(endMillis))
                        .build(),
                InstancesQuery.PROJECTION,
                selection,
                selectionArgs,
                null);

    } catch (Exception e) {
        Log.e(TAG, "Error querying calendar API", e);
        return null;
    }
}