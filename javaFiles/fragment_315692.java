appIdEndPoint.addValueEventListener(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    if (dataSnapshot.exists()) {
      appDetails address = dataSnapshot.getValue(appDetails.class);
      ...