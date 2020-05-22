YourAdapterClassName adapter = new YourAdapterClassName(...init adapter...)
adapter.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClicked(int position) {
         //Navigate here 
    }
})
yourRecyclerName.setAdapter(adapter)