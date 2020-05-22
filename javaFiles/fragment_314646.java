// during onCreate
RecyclerView rv = (RecyclerView)findViewById(R.id.recycler);
LayoutManager lm;
if(isPhone) {
   if(isLandscape) {
      lm = new GridLayoutManager(this, 2);
   } else {
      lm = new LinearLayoutManager(this);
   }
} else {
   if(isLandscape) {
      lm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
   } else {
      lm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
   }
}
rv.setLayoutManager(lm);
rv.setAdapter(... your adapter with the cards...);