@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Author author = (Author) parent.getItemAtPosition(position);

    Intent intent = new Intent(MainActivity.this, StoriesActivity.class);
    intent.putExtra("author_id", author.getID());
    intent.putExtra("author_name", author.getName());

    startActivity(intent);
}