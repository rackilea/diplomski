private String getContactNameFromNumber(String number) {
        // define the columns I want the query to return
        String[] projection = new String[] {
                Contacts.Phones.DISPLAY_NAME,
                Contacts.Phones.NUMBER };

        // encode the phone number and build the filter URI
        Uri contactUri = Uri.withAppendedPath(Contacts.Phones.CONTENT_FILTER_URL, Uri.encode(number));

        // query time
        Cursor c = getContentResolver().query(contactUri, projection, null,
                null, null);

        // if the query returns 1 or more results
        // return the first result
        if (c.moveToFirst()) {
            String name = c.getString(c
                    .getColumnIndex(Contacts.Phones.DISPLAY_NAME));
            return name;
        }

        // return the original number if no match was found
        return number;
    }