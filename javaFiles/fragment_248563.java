mUserDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    @SuppressWarnings("VisibleForTests")


                   for (DataSnapshot imageSnapshot : dataSnapshot.getChildren()) {
                              String name = dataSnapshot.child("name").getValue().toString();
                   String image = dataSnapshot.child("image").getValue().toString();
                   String status = dataSnapshot.child("status").getValue().toString();
                   String thumb_image = dataSnapshot.child("thumb_image").getValue().toString();
                    mName.setText(name);
                   mStatus.setText(status);
                            }
                        }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });