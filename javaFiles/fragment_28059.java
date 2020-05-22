reference.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                String parent = childSnapshot.getKey();
                  UserPojo user = childSnapshot.getValue(UserPojo.class);
//get your User ID
 String user = user.getUID();
                Log.i(TAG,parent);
            }
        }