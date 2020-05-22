String lookupKey = cursor.getString(
                 cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
Uri vcardUri = ContactsContract.Contacts.CONTENT_VCARD_URI
             .buildUpon().appendQueryParameter("nophoto", String.valueOf(true))
             .build();
Uri uri = Uri.withAppendedPath(vcardUri, lookupKey);