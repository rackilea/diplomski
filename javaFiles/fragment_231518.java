String[] PROJECTION = { 
ContactsContract.Contacts._ID, 
ContactsContract.Contacts.DISPLAY_NAME, 
ContactsContract.Contacts.HAS_PHONE_NUMBER
};
String selection = "(" + ContactsContract.Contacts.IN_VISIBLE_GROUP + 
" = '1' AND (" + ContactsContract.Contacts.HAS_PHONE_NUMBER + " != 0 ))";