public void addTen(View view) {
    mRef = new Firebase(my_private_url);
    mRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            value =(long) dataSnapshot.getValue();
            value = value + 10;
            dataSnapshot.getRef().setValue(value);
        }
        @Override
        public void onCancelled(FirebaseError firebaseError) {
        }
    });
}