ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC ");
        String lastnumber = "0";

        if (cur.getCount() > 0)
        {
            while (cur.moveToNext())
            {
                String number = null;
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                {
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]
                    { id }, null);
                    while (pCur.moveToNext())
                    {
                        number = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        Log.e("lastnumber ", lastnumber);
                        Log.e("number", number);

                        if (number.equals(lastnumber))
                        {

                        }
                        else
                        {
                            lastnumber = number;

                            Log.e("lastnumber ", lastnumber);
                            int type = pCur.getInt(pCur.getColumnIndex(Phone.TYPE));
                            switch (type)
                            {
                                case Phone.TYPE_HOME:
                                    Log.e("Not Inserted", "Not inserted");
                                    break;
                                case Phone.TYPE_MOBILE:

                                    databaseHandler.insertContact(id, name, lastnumber, 0);
                                    break;
                                case Phone.TYPE_WORK:
                                    Log.e("Not Inserted", "Not inserted");
                                    break;
                            }

                        }

                    }
                    pCur.close();
                }

            }
        }