databaseReference.child("category").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   for (int i=0;i<3;i++) {
                     // category is an ArrayList you can declare above
                        category.add(dataSnapshot.child(String.valueOf(i)).getValue(String.class));

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) { // Do something for this

                }
            });