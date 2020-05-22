@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    Intent i = new Intent(this, single_list_item_view.class);     
    HashMap<String, String> itemPressed = (HashMap<String, String>)l.getItemAtPosition(position); 
    String vehicleType = itemPressed.get(TAG_VTYPE);   
     i.putExtra("TAG_VTYPE", vehicleType); 
     startActivity(i); 
}