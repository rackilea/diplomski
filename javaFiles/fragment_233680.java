DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference customersRef = rootRef.child("Customers");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<AddCustomer> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            AddCustomer addCustomer = ds.getValue(AddCustomer.class);
            list.add(addCustomer);
        }
        ListView listView = (ListView) findViewById(R.id.list_view);
        YourCustomAdapter<AddCustomer> arrayAdapter = new YourCustomAdapter<AddCustomer>(this, list);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
customersRef.addListenerForSingleValueEvent(eventListener);