ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
        .withSelection(ContactsContract.Data.RAW_CONTACT_ID + "=?" + " and " + ContactsContract.Data.MIMETYPE + "=?",
        new String[]{String.valueOf(id), ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE})
        .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, firstname)
        .withValue(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME, lastname)
        .build());