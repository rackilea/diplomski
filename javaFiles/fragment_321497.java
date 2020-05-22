public static DatabaseReference mRootReference = FirebaseDatabase.getInstance().getReference();
public static DatabaseReference mReferenceForListA = mRootReference.child("List A");
Query query = mReferenceForListA.child("Items").orderByValue().equalTo("earphone");

query.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
            snapshot.getRef().removeValue();
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException();
    }
});