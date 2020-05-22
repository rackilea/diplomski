mLocationListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
    DatabaseReference db_node = FirebaseDatabase.getInstance().getReference().child("locations").child(mLocationAdapter.getItem(position).getRefKey());
    db_node.removeValue();
});