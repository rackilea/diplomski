lv.setAdapter(adapter);
lv.setOnItemClickListener( new OnItemClickListener()
{

    public void onItemClick(AdapterView<?> parent, View view, int position,
        long id) {
    Toast.makeText(MainActivity.this.this, "List View row Clicked at"+position,Toast.LENGTH_SHORT).show();
    }
});