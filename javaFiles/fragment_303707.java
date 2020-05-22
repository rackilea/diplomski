listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
   void onItemClick(AdapterView<?> parent, View view, int position, long id){
      final RowItemClass clickedItem  = (RowItemClass)parent.getItemAtPosition(position);
      Intent intent = new Intent(OuterActivityClass.this, itemDetails.class);
      intent.putExtra("itemId", clickedItem.id + "");
      startActivity(intent);
   }
});