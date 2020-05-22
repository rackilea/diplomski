FirebaseDatabase.getInstance().getReference().child("users")
            .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        User user = snapshot.getValue(User.class);
                        System.out.println(user.email);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });