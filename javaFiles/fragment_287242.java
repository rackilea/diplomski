grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
    @Override  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),text[position],Toast.LENGTH_LONG).show();
        Intent a = new Intent(getApplicationContext(),FullImage.class);
        a.putExtra("id", image[position]);
        startActivity(a);
    }
});