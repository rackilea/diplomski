public void readData(final MyCallback myCallback) {
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference usersRef = rootRef.child("Users");
    ValueEventListener eventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            List<String> al = new ArrayList<>();
            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                String name = ds.child("Name").getValue(String.class);
                String rId = ds.child("Phone_Number").getValue(String.class);
                al.add(name);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, al);
            ListView listView = (ListView) rootView.findViewById(R.id.usersList);
            listView.setAdapter(adapter);
            mProgressDialogue.dismiss();
            myCallback.onCallback(al);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Toast.makeText(getActivity(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
        }
    };
    usersRef.addListenerForSingleValueEvent(eventListener);
}