@Override
public void onViewCreated(View view, Bundle savedInstanceState){

    // Use FirebaseRecyclerAdapter here

    // Here you modify your LinearLayoutManager
    mLayoutManager = new LinearLayoutManager(MainActivity.this);
    mLayoutManager.setReverseLayout(true);
    mLayoutManager.setStackFromEnd(true);

    // Now set the layout manager and the adapter to the RecyclerView
    listView.setLayoutManager(mLayoutManager);
    listView.setAdapter(adapter);
}