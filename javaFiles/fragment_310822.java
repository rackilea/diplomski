public Uri getContactImage() {
    try {
        Cursor cur = this.ctx.getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                null,
                ContactsContract.Data.CONTACT_ID + "=" + this.getId() + " AND "
                        + ContactsContract.Data.MIMETYPE + "='"
                        + ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE + "'", null,
                null);
        if (cur != null) {
            if (!cur.moveToFirst()) {
                return null; // no photo
            }
        } else {
            return null; // error in cursor process
        }
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    Uri person = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long
            .parseLong(getId()));
    return Uri.withAppendedPath(person, ContactsContract.Contacts.Photo.CONTENT_DIRECTORY);
}