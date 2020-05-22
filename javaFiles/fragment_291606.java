Cursor c1 = cr.query(Contacts.CONTENT_URI,null,null,null,null);
while (c1.moveToNext()) {
   long contactId = cur.getLong(...);
   Cursor c2 = cr.query(Phone.CONTENT_URI, null, Phone.CONTACT_ID + "=" + contactId, null, null);
   String phone = c2.getString(...); 
   // add phone to some list or map
}
sendAllPhonesToServer();