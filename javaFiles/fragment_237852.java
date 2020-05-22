DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://myproj.firebaseio.com/groceries");
Query query = ref.limitToFirst(1);
query.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
            childSnapshot.getRef().removeValue();
        }
    }