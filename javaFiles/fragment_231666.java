mdatabase = FirebaseDatabase.getInstance().getReference().child("Department");
mdatabase.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
         List<String> departmentList = new ArrayList<>();
         for(DataSnapshot ds : dataSnapshot.getChildren()) {
             String departmentName = (String) ds.getValue();
             departmentList.add(departmentName);
         }
         setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, departmentList));
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
});