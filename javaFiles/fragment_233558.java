List<Integer> ret = new ArrayList<Integer>();
ContentResolver contentResolver = getActivity().getContentResolver();
// Row contacts content uri( access raw_contacts table. ).
Uri rawContactUri = ContactsContract.RawContacts.CONTENT_URI;
// Return _id column in contacts raw_contacts table.
String queryColumnArr[] = {ContactsContract.RawContacts._ID};
// Query raw_contacts table and return raw_contacts table _id.
Cursor cursor = contentResolver.query(rawContactUri, queryColumnArr, null, null, null);