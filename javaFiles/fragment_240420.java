public boolean contactExists(Context context, String number, ContentResolver contentResolver) {
    Cursor phones = contentResolver.query(ContactsContract.CommonDataKinds.Phone.
            CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
    while (phones.moveToNext()){
        String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        if(PhoneNumberUtils.compare(number, phoneNumber)){
            return true;
        }
    }
    return false;
}