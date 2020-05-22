private void setupRecyclerView() {

RecyclerView rv = findViewById(R.id.pinRecyclerView);
RecyclerAdapter ra = new RecyclerAdapter(this, db.getAll(), "1234");

rv.setLayoutManager(new LinearLayoutManager(this));
rv.setItemAnimator(new DefaultItemAnimator());
rv.setAdapter(ra);

}