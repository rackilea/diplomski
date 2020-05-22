DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("FacultyMember");
databaseReference.orderByChild("Name").equalTo(nameYouWant).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()){
          for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
               String uid = childSnapshot.getKey();
        }
        else
            // no such user exists

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) { // ToDo: Do something for errors too

    }
});