gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     @Override
     public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getApplicationContext(),gridArray.get(position).getPage(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("page", gridArray.get(position).getPage());                
        startActivity(intent);
      }
});