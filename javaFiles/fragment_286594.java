// Set up your RecyclerView with the appropriate Layout Manager
RecyclerView myRecycler = findViewById(R.id.my_recycler_id);
myRecycler.setLayoutManager(new LinearLayoutManager(this));

// Create your data set
myData = new ArrayList<MyDataType>();

// Create an instance of your adapter passing the data set into the constructor
myAdapter = new MyAdapter(this, myData);

// Set the Adapter on the RecyclerView directly within onCreate
// so that it doesn't get skipped
myRecycler.setAdapter(myAdapter);