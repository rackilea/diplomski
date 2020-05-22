public Cursor getList() {
        // Get the base URI for the People table in the Contacts content
        // provider.
        Uri contacts = ContactsContract.Contacts.CONTENT_URI;
        // Make the query.
        ContentResolver cr = ctx.getContentResolver();
        // Form an array specifying which columns to return.
        String[] projection = new String[] { ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME };

        Cursor managedCursor = cr.query(contacts, projection, null, null,
                ContactsContract.Contacts.DISPLAY_NAME
                        + " COLLATE LOCALIZED ASC");
        return managedCursor;
    }