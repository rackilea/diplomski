@Override
public void onListItemClick(ListView parent, View v, int position, long id) {
    if (position == appropriate_condition) {
        Intent intent = new Intent(this, Bradford.class);
        startActivity(intent);
    }
}