try {
    contList.clear();
    for (int i = 0; i < contactList.size(); i++) {
        Log.v(TAG, "Response: " + contactList.get(i));
        if (Integer.valueOf(contactList.get(i).get("asset_id")) == MainActivity.typeCurrency) {
            contList.add(contactList.get(i));
        }
    }
}catch (Exception e){
    e.getMessage();
}