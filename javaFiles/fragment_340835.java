public void setGridAdapter(){
    this.myCustomGridAdapter = adapter;
    GridView gv = (GridView)findViewById(R.id.gridview); 

    if(gv != null)
        gv.setAdapter(this.myCustomGridAdapter);
}