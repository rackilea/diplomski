while (cursor.moveToNext())
{
    int nameIdx = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
    String tmp = cursor.getString(nameIdx);
    //_contactAdapter.add(tmp);

    //  get all names in a new arraylist and then assign it to 
      arrayList.add(tmp);
}