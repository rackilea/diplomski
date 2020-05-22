String number = "0877777777";
Uri uri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
String[] projection = new String[]{ PhoneLookup._ID };

Cursor cur = getContentresolver().query(uri, projection, null, null, null);

// if other contacts have that phone as well, we simply take the first contact found.
if (cur != null && cur.moveToNext()) {
    Long id = cur.getLong(0);

    Intent intent = new Intent(Intent.ACTION_VIEW);
    Uri contactUri = Uri.withAppendedPath(Contacts.CONTENT_URI, String.valueOf(id));
    intent.setData(contactUri);
    context.startActivity(intent);

    cur.close();
}