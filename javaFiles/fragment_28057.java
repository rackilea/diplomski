DatabaseReference reference;
reference = FirebaseDatabase.getInstance.getReference();

reference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
            String parent = childSnapshot.getKey();
            Log.i(TAG,parent);
        }
    }