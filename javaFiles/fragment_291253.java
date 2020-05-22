Map<String, List<String>> contacts = new HashMap<String, List<String>>();

String[] projection = { Phone.CONTACT_ID, Phone.DISPLAY_NAME, Phone.NUMBER };
Cursor cur = cr.query(Phone.CONTENT_URI, projection, null, null, null);

while (cur != null && cur.moveToNext()) {
    long id = cur.getLong(0); // contact ID
    String name = cur.getString(1); // contact name
    String data = cur.getString(2); // the actual info, e.g. +1-212-555-1234

    Log.d(TAG, "got " + id + ", " + name + ", " + data);

    // add info to existing list if this contact-id was already found, or create a new list in case it's new
    String key = id + " - " + name;
    List<String> infos;
    if (contacts.containsKey(key)) {
        infos = contacts.get(key);
    } else {
        infos = new ArrayList<String>();
        contacts.put(key, infos);
    }
    infos.add(data);
}

// contacts will now contain a mapping from id+name to a list of phones.
// you can enforce uniqueness of phones while adding them to the list as well.