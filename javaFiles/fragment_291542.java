@Override
public void onResume() {
    super.onResume();

    Intent receivedIntent = getIntent();
    selectedName = receivedIntent.getStringExtra("name");
    selectedID = receivedIntent.getIntExtra("id", 1); // NOTE: -1 is just the default value
    selectedSearchUrl = receivedIntent.getStringExtra("url");

    sEngineAdapter = new SearchEngineAdapter(context, arrayList, selectedID);
    paramRecyclerView.setAdapter(sEngineAdapter);
}