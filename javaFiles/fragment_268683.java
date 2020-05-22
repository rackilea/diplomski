String number = "0877777777";
Uri uri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
String[] projection = new String[]{ PhoneLookup._ID, PhoneLookup.DISPLAY_NAME };

Cursor cur = getContentresolver().query(uri, projection, null, null, null);

if (cur != null) {
   while (cur.moveToNext()) {
      Long id = cur.getLong(0);
      String name = cur.getString(1);
      Log.d("My Contacts", "found: " + id + " - " + name);
   }
   cur.close();
}