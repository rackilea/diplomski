DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference postsRef = rootRef.child("users").child("user1").child("posts");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String title = ds.child("title").getValue(String.class);
            String body = ds.child("body").getValue(String.class);
            list.add(title + " / " +  body);
            Log.d("TAG", title + " / " +  body);
        }
        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
postsRef .addListenerForSingleValueEvent(eventListener);