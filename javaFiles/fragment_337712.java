getContact()
// Getting single contact
public Contact getContact(int id) {
SQLiteDatabase db = this.getReadableDatabase();

Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
        KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
        new String[] { String.valueOf(id) }, null, null, null, null);
if (cursor != null)
    cursor.moveToFirst();

Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
        cursor.getString(1), cursor.getString(2));
// return contact
return contact;
}