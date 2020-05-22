DatabaseReference mDatabaseReference= FirebaseDatabase.getInstance().getReference(chatListTableName);

        mDatabaseReference.child(groupImageTable).child(groupId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Glide.with(GroupProfile.this).load(dataSnapshot.child("groupImageUrl")
                                .getValue()).into(userImage);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });