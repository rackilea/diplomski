mListView.setOnItemClickListener(new OnItemClickListener() {
  @Override
  public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
    Intent i = new Intent(MyActivity.this, MyOtherActivity.class);
    i.putExtra("database_id", id);
    startActivity(i);
  }
});