@Override  
    protected void onListItemClick(ListView l, View v, int pos, long id) {  
        super.onListItemClick(l, v, pos, id);

        if (adapter.getCount() != adapter.getItemId(pos)) {
           adapter.remove(adapter.getItem(pos));
           adapter.notifyDataSetChanged();     
       }        
}