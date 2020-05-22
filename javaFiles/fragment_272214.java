DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Agenti");
databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
            if (childSnapshot.exists() && childSnapshot.getChildrenCount() > 0) {
                String day = childSnapshot.child("ck").child("zile").getValue().toString();
                Toast.makeText(CalendarClienti.this, day, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});