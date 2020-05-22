List<String> amountList   = new ArrayList<>();
List<String> ridList      = new ArrayList<>();
List<String> dateTimeList = new ArrayList<>();     
FirebaseDatabase.getInstance().getReference().child("payments").child(firebaseAuth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
   @Override
   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    for(DataSnapshot ds : dataSnapshot.getChildren()){
        String amount    = ds.child("amount").getValue(String.class);
        String rid       = ds.child("rid").getValue(String.class);
        String dateTime  = ds.child("date_time").getValue(String.class);
        amountList.add(amount);
        ridList.add(rid);
        dateTimeList.add(dateTime);
     }             
   }

   @Override
   public void onCancelled(@NonNull DatabaseError databaseError) {

    }
  });