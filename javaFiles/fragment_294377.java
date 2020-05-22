private void getCurrentTask() {
    ...
    dRef1.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            ... (point 1)
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {}
    });

    ... (point 2)
}