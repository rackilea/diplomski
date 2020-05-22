ref.orderByChild("Name").equalTo("MyFirstName").addListenerForSingleValueEvent(new ValueEventListener() {
  public void onDataChange(DataSnapshot snapshot) {
    for (DataSnapshot item: snapshot.getChildren()) {
      item.child("Name").getRef().setValue("Aizen");
    }
  }
  public void onCancelled(FirebaseError firebaseError) {
  }
});