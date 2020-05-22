MatrixCursor cursor = new MatrixCursor(new String[] {"type", "_id", "detail", "optional_data", "lob_data"});
Cursor c;
String selection;
String search = selectionArgs[0].toLowerCase();
try {
    selection = "("+ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " LIKE ?) collate nocase";
    c = mContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
        new String[]{ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
                ContactsContract.Contacts.PHOTO_URI},
            selection,
            new String[]{"%"+search+"%"},
            null);
    c.moveToFirst();
    //c.moveToNext();
    while (c.moveToNext()) {
            Object[] rowObject = new Object[] {"Contact", c.getString(0), c.getString(1), null, imageToByte(c.getString(2))};
            cursor.addRow(rowObject);
        //c.moveToNext();
    }
}
catch (Exception e){
    Log.e(TAG, "URI problem with Contacts: "+e);
}