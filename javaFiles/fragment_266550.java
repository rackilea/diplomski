@Override
protected void onListItemClick(ListView list, View view, int position, long id) {
    Toast.makeText(this, "Item clicked" + position, Toast.LENGTH_LONG).show();

    // perform required action
}