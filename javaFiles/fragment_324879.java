ref.addListenerForSingleValueEvent(new ValueEventListener() {
   @Override
   public void onDataChange(DataSnapshot dataSnapshot) {
        YourModelClass result = dataSnapshot.getValue(YourModelClass.class);
        if(result != null){
            tcs.setResult(result);
        }
   }

   @Override
   public void onCancelled(DatabaseError databaseError){
        //handle error
   }
});