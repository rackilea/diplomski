ref.child("-JlvccKbEAyoLL9dc9_v").addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot snapshot) {
    if (snapshot.exists()) {
      // TODO: handle the case where the data already exists
    }
    else {
      // TODO: handle the case where the data does not yet exist
    }
  }

  @Override
  public void onCancelled(FirebaseError firebaseError) { }
});