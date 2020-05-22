Firebase ref = new Firebase("https://stackoverflow.firebaseio.com/32108969/users");

ref.addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot usersSnapshot) {
    for (DataSnapshot userSnapshot : usersSnapshot.getChildren()) {
      User user = userSnapshot.getValue(User.class);
      System.out.println(user.toString());
    }
  }

  @Override
  public void onCancelled(FirebaseError firebaseError) { }
});