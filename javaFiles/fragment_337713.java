getAllContacts()
// Getting All Contacts
public List<Contact> getAllContacts() {
List<Contact> contactList = new ArrayList<Contact>();
// Select All Query
String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
if (cursor.moveToFirst()) {
    do {
        Contact contact = new Contact();
        contact.setID(Integer.parseInt(cursor.getString(0)));
        contact.setName(cursor.getString(1));
        contact.setPhoneNumber(cursor.getString(2));
        // Adding contact to list
        contactList.add(contact);
    } while (cursor.moveToNext());
}

// return contact list
return contactList;
}