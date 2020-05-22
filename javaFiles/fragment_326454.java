List<String> keyList = new ArrayList<>();

databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()) {
            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                keyList.add(ds.getKey());
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError error) {

    }
});