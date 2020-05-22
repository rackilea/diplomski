valueEventListenerLeitor = favoritosRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.child("leitura").getValue().equals("horizontal")) {
            Log.e("TAG", "=======" + dataSnapshot.child("leitura").getValue());
        } else {
            Log.e("TAG", "=======" + "Vertical");
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});