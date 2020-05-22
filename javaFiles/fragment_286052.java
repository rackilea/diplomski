Firebase srcRef = new Firebase("https://stackoverflow.firebaseio.com/32108969/users");
final Firebase copyRef = new Firebase("https://stackoverflow.firebaseio.com/32108969/copiedusers");

srcRef.addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot usersSnapshot) {
    for (DataSnapshot userSnapshot : usersSnapshot.getChildren()) {
      User user = userSnapshot.getValue(User.class);
      copyRef.child(userSnapshot.getKey()).setValue(user);
    }
  }

  @Override
  public void onCancelled(FirebaseError firebaseError) { }
});