new CursorLoader(getActivity(), 
        ContactsContract.Contacts.CONTENT_URI,
        PROJECTION,
        SELECTION,
        mSelectionArgs,
        "data ASC");