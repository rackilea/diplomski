@Override
public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
    if (cursor.getCount() == 0) return;

    Log.d(TAG, "Search Query: " + query);
    while (cursor.moveToNext()) {
        String displayName =  cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
        Log.d(TAG, displayName);
    }
    cursor.close();
}