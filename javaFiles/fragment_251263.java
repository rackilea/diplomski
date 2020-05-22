@Override
public void onActivityResult(int reqCode, int resultCode, Intent data){
    super.onActivityResult(reqCode, resultCode, data);

    if(reqCode == this.pickContact){
        if (resultCode == Activity.RESULT_OK) {
            Log.d("ContactsH", "ResOK");
            Uri contactData = data.getData();
            Cursor contact =  getContentResolver().query(contactData, null, null, null, null);

            if (contact.moveToFirst()) {
                String name = contact.getString(contact.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                // TODO Whatever you want to do with the selected contact's name.

                ContentResolver cr = getContentResolver();
                Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
                        "DISPLAY_NAME = '" + name + "'", null, null);
                if (cursor.moveToFirst()) {
                    String contactId =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    //
                    //  Get all phone numbers.
                    //
                    Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                    while (phones.moveToNext()) {
                        String number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        int type = phones.getInt(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                        switch (type) {
                            case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                                // do something with the Home number here...
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                                // do something with the Mobile number here...
                                Log.d("ContactsH", number);
                                this.callByNumber(number);
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                                // do something with the Work number here...
                                break;
                        }
                    }
                    phones.close();
                }
                cursor.close();
            }
        }
    }else{
        Log.d("ContactsH", "Canceled");
    }
}