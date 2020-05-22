Firebase ref = new Firebase("https://yours.firebaseio.com");
Query messages = ref.orderByKey().limitToLast(1);
messages.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Log.i("Messages", dataSnapshot.toString());
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
})