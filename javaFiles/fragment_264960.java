//under class declaration do this:
   private ArrayList<String> itemlists;




itemLists=new ArrayList<String>();
 databaseItems.child("items").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot itemSnapShot : dataSnapshot.getChildren()) {
            String itemname=itemSnapShot.child("itemName").getValue().toString();

            itemlists.add(itemname);
ArrayAdapter adapter = new ArrayAdapter(SearchActivity.this,android.R.layout.simple_list_item_1 itemlists);
        listFinal.setAdapter(adapter);

        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});
}