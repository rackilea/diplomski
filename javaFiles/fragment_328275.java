ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Users> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Users users = ds.getValue(Users.class);
            list.add(users);
        }

        Users firstUser = list.get(0);
        Users secondUser = list.get(1);
        Users thirdUser = list.get(2);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
myRef.addListenerForSingleValueEvent(valueEventListener);