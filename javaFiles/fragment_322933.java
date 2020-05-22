String selectArgs1 = Data.CONTACT_ID + "=? AND " + Data.MIMETYPE + "= ? ";
    String[] selectArgs2 = new String[]{contactId, "vnd.android.cursor.item/note"}; 
    operationList.add(ContentProviderOperation.newUpdate(Data.CONTENT_URI)
            .withSelection(selectArgs1, selectArgs2)
            .withValue(ContactsContract.CommonDataKinds.Note.NOTE, "hello@hi.com")
            .build());