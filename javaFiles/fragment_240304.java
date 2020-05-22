RecyclerView recyclerView = findViewById(R.id.recyclerView_list);
LayoutManager layoutManager;
if(isScreenSmall){
    layoutManager = new LinearLayoutManager(this);
    // maybe use special ItemDecoration for small devices
}
else{
    int numberOfColumns = 2;
    layoutManager = new GridLayoutManager(this, numberOfColumns);
    // maybe use special ItemDecoration for large devices
}
recyclerView.setLayoutManager(layoutManager);
MyAdapter adapter = new MyAdapter(this, dataArray);
adapter.setClickListener(this);
recyclerView.setAdapter(adapter);