Map<Long, String> phonesMap = new HashMap<>(); // mapping from contactId to phone
String[] projection = new String[] { Phone.CONTACT_ID, Phone.NORMALIZED_NUMBER }; // if you need to support API 15 and below, change to Phone.NUMBER
Cursor c = cr.query(Phone.CONTENT_URI,projection,null,null,null);
while (c.moveToNext()) {
   long contactId = c.getLong(0);
   String phone = c.getString(1);
   phonesMap.put(contactId, phone); 
}
sendAllPhonesToServer(phonesMap);