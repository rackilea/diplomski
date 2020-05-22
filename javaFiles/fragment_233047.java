@Override
 public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
   VictoriaListAdapter adapter = (VictoriaListAdapter) parent.getAdapter();

   //reverse the selected state in data model
   for (int i = 0; i < adapter.getCount(); i++) {
     Victoria victoria = (Victoria)adapter.getItem(i);
     victoria.setSelected(i == position ? true : false);
   }
   Victoria victoria = (Victoria)adapter.getItem(position);

   ---
   ---