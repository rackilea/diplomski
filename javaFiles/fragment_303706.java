listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
   void onItemClick(AdapterView<?> parent, View view, int position, long id){
      Intent intent = new Intent(OuterActivityClass.this, itemDetails.class);
      intent.putExtra("itemId", id + ""); //+ "" to make it string, of course you can use long but you have to remeber to use intent.getLongExtra(...) in details Activity
      startActivity(intent);
   }
});