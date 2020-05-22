int scoreTotal=0;
Query myTopPostsQuery = databaseReference.child("Posts").orderByChild("uid").equalTo(userId);
myTopPostsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue()!=null){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren())
                      scoreTotal= scoreTotal+ (int) snapshot.child("score").getValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });