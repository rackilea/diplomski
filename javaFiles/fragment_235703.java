ContentResolver cr = mContext.getContentResolver(); //Activity/Application android.content.Context
    Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    if(cursor.moveToFirst())
    {
        ArrayList<String> alContacts = new ArrayList<String>();
        do
        {
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

            if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
            {
                Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",new String[]{ id }, null);
                while (pCur.moveToNext()) 
                {
                    String contactNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    alContacts.add(contactNumber);
                    break;
                }
                pCur.close();
            }

        } while (cursor.moveToNext()) ;
    }