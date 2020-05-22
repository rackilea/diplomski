// Data content uri (access data table. )
Uri dataContentUri = ContactsContract.Data.CONTENT_URI;
// Build query columns name array.
List<String> queryColumnList = new ArrayList<String>();
// ContactsContract.Data.CONTACT_ID = "contact_id";
queryColumnList.add(ContactsContract.Data.CONTACT_ID);
// ContactsContract.Data.MIMETYPE = "mimetype";
queryColumnList.add(ContactsContract.Data.MIMETYPE);
queryColumnList.add(ContactsContract.Data.DATA1);
queryColumnList.add(ContactsContract.Data.DATA2);
queryColumnList.add(ContactsContract.Data.DATA3);
queryColumnList.add(ContactsContract.Data.DATA4);
queryColumnList.add(ContactsContract.Data.DATA5);
queryColumnList.add(ContactsContract.Data.DATA6);
queryColumnList.add(ContactsContract.Data.DATA7);
queryColumnList.add(ContactsContract.Data.DATA8);
queryColumnList.add(ContactsContract.Data.DATA9);
queryColumnList.add(ContactsContract.Data.DATA10);
queryColumnList.add(ContactsContract.Data.DATA11);
queryColumnList.add(ContactsContract.Data.DATA12);
queryColumnList.add(ContactsContract.Data.DATA13);
queryColumnList.add(ContactsContract.Data.DATA14);
queryColumnList.add(ContactsContract.Data.DATA15);
// Translate column name list to array.
String queryColumnArr[] = queryColumnList.toArray(new String[queryColumnList.size()]);
// Build query condition string. Query rows by contact id.
StringBuffer whereClauseBuf = new StringBuffer();
whereClauseBuf.append(ContactsContract.Data.RAW_CONTACT_ID);
whereClauseBuf.append("=");
whereClauseBuf.append(rawContactId);
// Query data table and return related contact data.
Cursor cursor = contentResolver.query(dataContentUri, queryColumnArr, whereClauseBuf.toString(), null, null);