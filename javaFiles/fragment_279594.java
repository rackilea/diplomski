String[] projection = {Phone.NUMBER, Email.DATA, Contacts.DISPLAY_NAME};
Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);

int column = cursor.getColumnIndex(Phone.NUMBER);
int column1 = cursor.getColumnIndex(Email.DATA);
int column2= cursor.getColumnIndex(Contacts.DISPLAY_NAME);
if(cursor.moveToFirst()) { // Check if data exists
     String number = cursor.getString(column);
     String email1 = cursor.getString(column1);
     String name1 = cursor.getString(column2)
}