for (long contactId : lv.getCheckedItemIds()) {
    String selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?";
    String[] args = new String[] { String.valueOf(contactId) };
    Cursor cursor=managedQuery(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, selection, args, null);
    if (cursor.moveToFirst()) {
        // Get content here
    }
}