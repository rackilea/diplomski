String where = ContactsContract.Data.MIMETYPE + "=? OR " + ContactsContract.Data.MIMETYPE + "=?";
String[] whereValues = new String[]{ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE};

String[] dataProjection = new String[]{ContactsContract.Data.CONTACT_ID, ContactsContract.Data.LOOKUP_KEY, ContactsContract.Data.DISPLAY_NAME_PRIMARY, ContactsContract.Data.STARRED, ContactsContract.Data.MIMETYPE, ContactsContract.Data.DATA1, ContactsContract.Data.DATA2, ContactsContract.Data.DATA_VERSION};
Cursor cursor =  context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, dataProjection, dataWhere, dataWhereValues, ContactsContract.Data.CONTACT_ID + " ASC");

int cidIndex = cursor.getColumnIndexOrThrow(ContactsContract.Data.CONTACT_ID);
int nameIndex = cursor.getColumnIndexOrThrow(ContactsContract.Data.DISPLAY_NAME_PRIMARY);
int starredIndex = cursor.getColumnIndexOrThrow(ContactsContract.Data.STARRED);
int typeIndex = cursor.getColumnIndexOrThrow(ContactsContract.Data.MIMETYPE);
int data1Index = cursor.getColumnIndexOrThrow(ContactsContract.Data.DATA1);
int data2Index = cursor.getColumnIndexOrThrow(ContactsContract.Data.DATA2);
int lookupKeyIndex = cursor.getColumnIndexOrThrow(ContactsContract.Data.LOOKUP_KEY);
int versionIndex = cursor.getColumnIndexOrThrow(ContactsContract.Data.DATA_VERSION);
boolean hasData = cursor.moveToNext();

while (hasData){
    contactId = cursor.getLong(cidIndex);
    nativeLookupKey = cursor.getString(lookupKeyIndex);
    fullName = cursor.getString(nameIndex);
    starred = cursor.getInt(starredIndex);
    version = cursor.getLong(versionIndex);

    while (currentContactId <= contactId && hasData) {
        if (currentContactId == contactId) {
            String type = cursor.getString(typeIndex);
            if (type.equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)) {
                String email = cursor.getString(data1Index);                      
            } else if (type.equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)) {
                String number = cursor.getString(data1Index);
            }
        }

        hasData = cursor.moveToNext();
        if (hasData) {
            currentContactId = cursor.getLong(cidIndex);
        }  
    }            
}