// during onCreate(Bundle)
users.addValueEventListener(listener);

// then during onDestroy()
users.removeValueEventListener(listener);

// outside any method you write the listener
private ValueEventListener listener = new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            getUserData(dataSnapshot);
        }
        @Override
        public void onCancelled(DatabaseError databaseError) {
        }
    }