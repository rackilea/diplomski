GridView gridView = (GridView) findViewById(R.id.gridview);
gridView.setAdapter(new MyAdapter(this));
gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Item item = parent.getAdapter().getItem(position);

    Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
    i.putExtra("imageResource", item.getImageResource);
    startActivity(i);
 }
});