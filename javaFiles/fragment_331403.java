DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("details");

  ref.orderByChild("username").equalTo(userNameYouWant).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for (DataSnapshot ds : dataSnapshot.getChildren()){
                                 email.add(ds.child("email").getValue(String.class)); // email here is the ArrayList where you need to add the email
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) { // ToDo: don't ignore this, do something for errors

                        }
                  )};