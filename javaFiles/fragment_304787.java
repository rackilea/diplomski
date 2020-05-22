databasefetch = FirebaseDatabase.getInstance().getReference().child("save");
Query query = databasefetch.orderByChild("id").equalTo(8901058862836L);
query.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
      for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
        TextView text = (TextView) findViewById(R.id.textView3);
        String name = snapshot.child("name").getValue(String.class);
        String details = snapshot.child("details").getValue(String.class);
        String price = snapshot.child("price").getValue(String.class);

        ...
      }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException(); // never ignore errors
    }
})