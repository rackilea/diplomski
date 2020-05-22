private void initRecyclerView() {


    //initializes and sets adapter 


    mRecyclerView = findViewById(R.id.chatRecyclerView);
    mAdapter = new ChatRecyclerViewAdapter(this, mMessages, mUsernames, mRoomID, mDatabaseReference);
    mRecyclerView.setAdapter(mAdapter);

    //Creates layout manager and makes it feed new RecyclerView views from the bottom


    final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setStackFromEnd(true);

    //Makes RecyclerView scroll to bottom when notifyItemInserted is called from adapter and RecyclerView is already at bottom

    RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);


            if (isAtBottom) {
                mRecyclerView.smoothScrollToPosition(mAdapter.getItemCount() - 1);
            } else {
            }
        }
    };

    //Adds logic to see if RecyclerView is at bottom or not

    mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

            if (!recyclerView.canScrollVertically(1)) {
                isAtBottom = true;
            } else {
                isAtBottom = false;
            }
        }
    });

    //Assigns observer to adapter and LayoutManager to RecyclerView

    mAdapter.registerAdapterDataObserver(observer);
    mRecyclerView.setLayoutManager(linearLayoutManager);

}