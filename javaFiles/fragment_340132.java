databaseReference = FirebaseDatabase.getInstance().getReference().child("appointment");

        databaseReference.orderByChild("userid").equalTo(userid1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    String theraid = dataSnapshot1.child("theraid").getValue(String.class);

                    DatabaseReference refThera = FirebaseDatabase.getInstance().getReference().child("alluser").child("thera");
                    refThera.child(theraid).addValueEventListener(new ValueEventListener() {
                    @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       String name = dataSnapshot.child("name").getValue(String.class);
                       }

                    @Override
                 public void onCancelled(@NonNull DatabaseError databaseError) {
                      Toast.makeText(getApplicationContext(), "Oh no!", Toast.LENGTH_SHORT).show();
                      throw databaseError.toException(); 
                    }
              });


               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Oh no!", Toast.LENGTH_SHORT).show();
                throw databaseError.toException();
            }
        });