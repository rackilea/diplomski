Database currentJobRef = FirebaseDatabase.getInstance().getReference("CurrentJob");
currentJobRef.addValueEventListener(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot valueSnapshot: dataSnapshot.getChildren()) {
      System.out.println(valueSnapshot.getKey()); // prints "washed", "published", "waxed"
      System.out.println(valueSnapshot.getValue(Boolean.class)); prints true, false, false
    }
  }

  @Override
  public void onCancelled(DatabaseError databaseError) {
    throw databaseError.toException();
  }
});