groupRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        ArrayList<String> groupChatNames = new ArrayList<>();
        for (DataSnapshot child : dataSnapshot.getChildren()) {
            groupChatNames.add(child.getKey());
        }
        Adapter adapter = new Adapter(groupChatNames);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});