private void doSomethingForEachUniquePhoneNumber(Context context) {
    String[] projection = new String[] {
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER,
            //plus any other properties you wish to query
    };

    Cursor cursor = null;
    try {
        cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection, null, null, null);
    } catch (SecurityException e) {
        //SecurityException can be thrown if we don't have the right permissions
    }

    if (cursor != null) {
        try {
            HashSet<String> normalizedNumbersAlreadyFound = new HashSet<>();
            int indexOfNormalizedNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER);
            int indexOfDisplayName = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int indexOfDisplayNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

            while (cursor.moveToNext()) {
                String normalizedNumber = cursor.getString(indexOfNormalizedNumber);
                if (normalizedNumbersAlreadyFound.add(normalizedNumber)) {
                    String displayName = cursor.getString(indexOfDisplayName);
                    String displayNumber = cursor.getString(indexOfDisplayNumber);
                    //haven't seen this number yet: do something with this contact!
                } else {
                    //don't do anything with this contact because we've already found this number
                }
            }
        } finally {
            cursor.close();
        }
    }
}