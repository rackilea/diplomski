protected void onResume() {
    super.onResume();
    searchPlugin.setText("");
    getChangeColor();

    // Set the adapter here 
    sEngineAdapter = new SearchEngineAdapter(context, arrayList, selectedItem);
    paramRecyclerView.setAdapter(sEngineAdapter);
}