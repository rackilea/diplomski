EditText edit = (EditText)findViewById(R.id.delText);
final String name = edit.getText().toString();
Query query = mRef.child("Breakfast/Name").orderByValue().equalTo(name);
query.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
            itemSnapshot.getRef().removeValue();
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
});
edit.setText("");