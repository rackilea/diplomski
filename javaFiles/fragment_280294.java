@Override
protected void onListItemClick(ListView l, View v, int position, long id) {

    listItems.remove(position);
    adapter.notifyDataSetChanged();

}