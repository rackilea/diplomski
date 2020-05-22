DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref = rootRef.child("Quiz").child("MCQ").child("Question").child("1831");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        ArrayList<String> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String key = ds.getKey();
            list.add(key);
        }
        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Go to next activity
            }
        });
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
ref.addListenerForSingleValueEvent(valueEventListener);