protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.food_activity);
    findRestaurantKey();
}


private void findRestaurantKey() {
    mDatabase = FirebaseDatabase.getInstance();
    mDatabaseReference = mDatabase.getReference("x");
    mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    allRestNames.add(d.getKey());
                }

                // HERE is when the data is available from the Firebase service
                Log.d("ARRAY" , allRestNames.toString());
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}