paramRecyclerView = findViewById(R.id.lvEngines);
paramRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
paramRecyclerView.setHasFixedSize(true);

// Remove the following
// Intent intent = getIntent();
// int intValue = intent.getIntExtra("selected", 0);

// Move the adapter setup to the onResume
// sEngineAdapter = new SearchEngineAdapter(context, arrayList, selectedItem);
// paramRecyclerView.setAdapter(sEngineAdapter);

// Calling network APIs to populate the arrayList.