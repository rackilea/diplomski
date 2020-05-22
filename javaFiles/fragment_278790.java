private void enlistMickey() throws RemoteException, OperationApplicationException {
    final ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
    ContentProviderOperation.Builder builder;

    builder = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
    builder.withValue(RawContacts.ACCOUNT_NAME, null);
    builder.withValue(RawContacts.ACCOUNT_TYPE, null);
    ops.add(builder.build());

    builder = ContentProviderOperation.newInsert(Data.CONTENT_URI);
    builder.withValueBackReference(StructuredName.RAW_CONTACT_ID, 0);
    builder.withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
    builder.withValue(StructuredName.GIVEN_NAME, "Mickey");
    builder.withValue(StructuredName.FAMILY_NAME, "Mouse");
    ops.add(builder.build());

    builder = ContentProviderOperation.newInsert(Data.CONTENT_URI);
    builder.withValueBackReference(Phone.RAW_CONTACT_ID, 0);
    builder.withValue(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
    builder.withValue(Phone.NUMBER, "01234567891");
    ops.add(builder.build());

    builder = ContentProviderOperation.newInsert(Data.CONTENT_URI);
    builder.withValueBackReference(Email.RAW_CONTACT_ID, 0);
    builder.withValue(Data.MIMETYPE, Email.CONTENT_ITEM_TYPE);
    builder.withValue(Email.DATA, "mickey@disney.com");
    ops.add(builder.build());

    final ContentResolver cr = getContentResolver();
    final ContentProviderResult[] res = cr.applyBatch(ContactsContract.AUTHORITY, ops);
    final Uri uri = ContactsContract.RawContacts.getContactLookupUri(cr, res[0].uri);
    final Intent intent = new Intent();
    intent.setAction(Intent.ACTION_EDIT);
    intent.setData(uri);
    startActivityForResult(intent, REQUEST_CODE);
}