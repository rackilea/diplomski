void trythiscode(){
   // An array specifying which columns to return.
   String[] projection = new String[] {
   People._ID,
   People.NAME,
   People.NUMBER,
};

   // Get the base URI for People table in Contacts content provider.
   // which is: content://contacts/people/
   Uri contactUri = People.CONTENT_URI;

   // Best way to retrieve a query; returns a managed query.
   Cursor peopleCursor = managedQuery (contactUri,
     projection, //Which columns to return.
     null, // WHERE clause--we won't specify.
     null, // Selection Args??
     People.DEFAULT_SORT_ORDER); // Order-by name

   // go to the beginning of the list
   peopleCursor.moveToFirst();


   // So, here we have a contact. We need to get the contact ID (_id) then
   // build the Uri to get the phones section of that user's record
   // which is a subdirectory of a contact record

   long personId = peopleCursor.getLong(peopleCursor.getColumnIndex("_id"));

   Uri personUri = ContentUris.withAppendedId(contactUri, personId );

   // So now the URL looks like: content://contacts/people/_id(where the actual id of the record is here)
   Uri phoneUri=
    Uri.withAppendedPath(personUri, Contacts.People.Phones.CONTENT_DIRECTORY);

   // Now the URL looks like: content://contacts/people/_id/phones (where phones is literally "phones")

   // Now get all the phone numbers for this contact
   Cursor phonesCursor = managedQuery(phoneUri,
     null,
     null,
     null,
     Phones.DEFAULT_SORT_ORDER);

   // We now have a cursor for all the phone numbers for that User ID
   // go to the beginning of the phone list.
   phonesCursor.moveToFirst();


}