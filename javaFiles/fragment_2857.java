public void onDataChange(DataSnapshot dataSnapshot) {
    ArrayList<String> userlist = new ArrayList<String>();
    ArrayList<String> keylist = new ArrayList<String>();
    for(DataSnapshot dsp : dataSnapshot.getChildren()) {
        userlist.add(String.valueOf(dsp.getValue()));
        keylist.add(dsp.getKey());
    }
    int randpos = new Random().nextInt(userlist.size());
    Object randomitem = userlist.get(randpos);
    String key = keylist.get(randpos);
    Toast.makeText(getBaseContext(), randomitem.toString() + " key:" + key, Toast.LENGTH_LONG).show();
}