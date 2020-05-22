String name = null;

while (phones_cursor.moveToNext())
{
  name = phones_cursor.getString(phones_cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
}
Log.wtf("Name: ", name);