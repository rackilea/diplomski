mdatabaseReference
  .child("Answer")
  .child("Q1")
  .addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
      for (DataSnapshot answerSnapshot: dataSnapshot.getChildren()) {
        System.out.println(answerSnapshot.child("Answer").getValue());
      }
    }
    ...