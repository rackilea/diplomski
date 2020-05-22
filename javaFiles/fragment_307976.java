mDatabaseReference2 = FirebaseDatabase.getInstance().getReference("User");
mDatabaseReference2.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
       for(DataSnapshot postSnapshot:dataSnapshot.getChildren())
        {
            String myParentNode = postSnapshot.getKey();
            mDatabaseReference  = FirebaseDatabase.getInstance().getReference();
            mDatabaseReference.orderByKey().equalTo(myParentNode).addValueEventListener(new ValueEventListener() {
             @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              for(DataSnapshot posts :dataSnapshot.getChildren())
               {
                    String key = posts.getKey();
                    if(key.equals(myParentNode))
                          Toast.makeText(Manageordergrocery.this,"equals", Toast.LENGTH_LONG).show();
               } 
              }

           @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {}
         });
       }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Toast.makeText(Manageordergrocery.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
    }
});