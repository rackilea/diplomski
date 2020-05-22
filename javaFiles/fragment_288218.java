private void getContacts() {
    List<String> addresses = new ArrayList<String>();    

    // Run query

    Uri uri = Contact.CONTENT_URI;
    String[] projection = new String[] { Contact.COLUMN_EMAIL };
    String selection = null;
    String[] selectionArgs = null;
    String sortOrder = Contact.COLUMN_EMAIL
            + " COLLATE LOCALIZED ASC";
    Cursor cursor = getContentResolver().query(uri, projection, selection, selectionArgs,
            sortOrder);
    TextView emailText = (TextView) findViewById(R.id.emailText);
    if (cursor != null) {
        cursor.moveToFirst();
        String category;
        for (int i = 0; i < cursor.getCount(); i++){
            category = cursor.getString(cursor
            .getColumnIndexOrThrow(Contact.COLUMN_EMAIL));
            addresses.add(category);
            cursor.moveToNext();
        }
        // always close the cursor
        cursor.close();
    }
}