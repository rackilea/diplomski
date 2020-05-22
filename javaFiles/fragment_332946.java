DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference mealsRef = rootRef.child("meals");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot uidSnapshot : dataSnapshot.getChildren()) {
            String uid = uidSnapshot.getKey();

            DatabaseReference uidRef = rootRef.child("meals").child(uid).startAt("ggh").endAt("ggh" + "\uf8ff");
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        String mealName = ds.child("meal_name").getValue(String.class);
                        Log.d(TAG, mealName);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(TAG, databaseError.getMessage());
                }
            };
            uidRef.addListenerForSingleValueEvent(eventListener);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
mealsRef.addListenerForSingleValueEvent(valueEventListener);