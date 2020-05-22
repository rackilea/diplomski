ArrayList<JSONObject> contacts = new ArrayList<>();

public void addContacts(){

    //to store name-number pair
    JSONObject obj = new JSONObject();

    try {
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        while (phones.moveToNext()) {
            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            obj.put(name, phoneNumber);
            contacts.add(obj);

            Log.e("Contact list with name & numbers", " "+contacts);
        }
        phones.close();
    }
    catch (Exception e){
        e.printStackTrace();
    }
}