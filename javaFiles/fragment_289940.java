@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Intent intent = new Intent(getApplicationContext(), SingleItem.class);
    Item item = adapter.getItem(position);
    intent.putExtra("yourItem", name);
    startActivity(intent);
}