Query results = user_information.child(user.getUid() + "/Clock_In").limitToLast(10);


results.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
         // Clear your list view, it's about to be repopulated
        for (DataSnapshot clockIn: dataSnapshot.getChildren()) {
             String clockOut = user_information.child(user.getUid() + "/Clock_out/" + clockIn.getKey()).getValue();
             // Add clockIn.getValue() and clockOut to your listview here
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // ...
    }
});