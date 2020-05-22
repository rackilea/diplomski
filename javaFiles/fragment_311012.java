public void getNextUser() {
  if (list.size() > 0) {
    String uid = list.get(0)
    list.remove(0);
    usersRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            User user = dataSnapshot.getValue(User.class);

            getNextUser()
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) { throw databaseError.toException(); }
    });
  }
}