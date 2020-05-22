FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference fDatabaseRoot = database.getReference();

fDatabaseRoot.child("properties").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // Is better to use a List, because you don't know the size
            // of the iterator returned by dataSnapshot.getChildren() to
            // initialize the array
            final List<String> propertyAddressList = new ArrayList<String>();

            for (DataSnapshot addressSnapshot: dataSnapshot.getChildren()) {
                String propertyAddress = addressSnapshot.child("propertyAddress").getValue(String.class);
                if (propertyAddress!=null){
                    propertyAddressList.add(propertyAddress);
                }
            }

            Spinner spinnerProperty = (Spinner) findViewById(R.id.maintenanceProperty);
            ArrayAdapter<String> addressAdapter = new ArrayAdapter<String>(MaintenanceActivity.this, android.R.layout.simple_spinner_item, propertyAddressList);
            addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerProperty.setAdapter(addressAdapter);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });