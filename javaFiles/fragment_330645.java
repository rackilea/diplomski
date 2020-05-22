private void onSetRecyclerView() {
    recyclerView = findViewById(R.id.recyclerView);
    CenterZoomLayoutManager layoutManager =
        new CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
    // Scroll to the position we want to snap to
    layoutManager.scrollToPosition(storeList.size() / 2);
    // Wait until the RecyclerView is laid out.
    recyclerView.post(new Runnable() {
        @Override
        public void run() {
            // Shift the view to snap  near the center of the screen.
            // This does not have to be precise.
            int dx = (recyclerView.getWidth() - recyclerView.getChildAt(0).getWidth()) / 2;
            recyclerView.scrollBy(-dx, 0);
            // Assign the LinearSnapHelper that will initially snap the near-center view.
            LinearSnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(recyclerView);
        }
    });
}