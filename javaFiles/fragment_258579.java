mDBRefUsers = mDatabase.getReference("/users/");
mDBRefUsers.addListenerForSingleValueEvent(new ValueEventListener() {
   @Override
   public void onDataChange(DataSnapshot dataSnapshot) {
           // dataSnapshot .. hold list of users keys .. now you can hold it to set your listener
           for(DataSnapshot dataSnapShot1 : dataSnapshot.getChildren()){
                  mDBRefUsers.child(dataSnapShot1.getValue(String.class))
                  .child("mHotZoneRecord")
                  .addChildEventListener(new HotZoneNotification(this));
                  // this equals users.child("-Kt8YIIAEH6EKXIbh3YN").child("mHotZoneRecord").[YOU LINSTER]

           }
   }