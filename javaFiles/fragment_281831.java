@Override  
protected void publishResults(CharSequence constraint, FilterResults results) {
    if (results.count == 0) 
        adapter.notifyDataSetInvalidated(); 
    else {  
        adapter.clear();
        adapter.addAll(results.values); 
        adapter.notifyDataSetChanged();
    }  
}