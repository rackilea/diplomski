DatabaseReference myRef = database.getReference();
myRef.child("User").addValueEventListener(new ValueEventListener() {
     @Override
   public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnasphot datas: dataSnapshot.getChildren()){
    String names=datas.child("Name").getValue().toString();
    String usernames=datas.child("Username").getValue().toString();
    editor.putString ("ussername",names);
    editor.putString ("name", usernames);
    editor.apply();
   }