List<User> userList=new ArrayList();
    mUserDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            @SuppressWarnings("VisibleForTests")

                           for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                                    User user = messageSnapshot.getValue(User.class);
                                    userList.add(user);
                                }
                            }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });