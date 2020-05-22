database.getReference().addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
            Log.d(TAG, userSnapshot.getKey()); // "1", "2"...
            Log.d(TAG, userSnapshot.getValue(String.class)); "Christine 20", "Tom 64"...
        }
    }


    @Override
    public void onCancelled(DatabaseError error) {
        Log.w(TAG, "Failed to read value.", error.toException()); // Don't ignore errors
    }

});