//mUserDatabase is a DatabaseReference
mUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot datas : dataSnapshot.getChildren()) {
                String uid = datas.getKey();

                //mUserKey is an ArrayList<String>
                mUserKey.add(uid);

                }
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });