if (Integer.parseInt(cur.getString(
           cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
        Cursor pCur = cr.query(
    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
    null, 
    ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", 
    new String[]{id}, null);
    while (pCur.moveToNext()) {
    // Do something with phones
    } 
    pCur.close();
}