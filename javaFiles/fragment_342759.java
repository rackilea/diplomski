myRef = database.getReference();  

  myRef.child("Users").child(userID).child("Feedings")
   .getReference().addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            showData(dataSnapshot);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });




private void showData(DataSnapshot dataSnapshot) {
    ArrayList<String> arrayList = new ArrayList<>();

    for(DataSnapshot ds: dataSnapshot.getChildren()){
        Feeding feeding = ds.getValue(Feeding.class);
        Log.d(TAG, "showData: name: " + feeding.getAmount());
        arrayList.add(feeding.getAmount());

    }


        ArrayAdapter adapter = new 
        ArrayAdapter(this,android.R.layout.simple_list_item_1, arrayList);
        mListView.setAdapter(adapter);
}