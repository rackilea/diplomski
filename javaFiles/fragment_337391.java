FirebaseDatabase.getInstance().getReference().child("Symptoms").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                String key = ds.getKey();
                FirebaseDatabase.getInstance().getReference().child("Symptoms").child(key).child("count").setValue("0");
            }
        }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });