public PlayerList getContacts(){
    ContentResolver cr = calledActivity.getContentResolver();
    Cursor contactList = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
    while (contactList.moveToNext()){
        contactPlayer = new PlayerDetails();
        contactPlayer.name = contactList.getString(contactList.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
        contactPlayer.number = contactList.getString(contactList.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        playerNameNumber.myPlayers.add(pos,contactPlayer);

        //playerNameNumber.add(pos,name + " " + phoneNumber);
        pos++;
    }
    return playerNameNumber;
}