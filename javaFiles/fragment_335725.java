private void populateRecyclerView()
{
    WallItem w = WallItemList.get(0);

    adapter.setItems(WallItemList);


    adapter.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(WallItem item) {
            // Function to start new activity
            Class detailActivity = DetailActivity.class;

            // Create intent
            Intent startDetailActivityIntent = new Intent(MainActivity.this, detailActivity);

            // Add object to intent
            startDetailActivityIntent.putExtra("detailWallItem", (Parcelable)item);

            // Start activity
            startActivity(startDetailActivityIntent);
        }
    });
}