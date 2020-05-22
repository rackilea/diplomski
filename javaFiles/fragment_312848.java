public void updateListContent() {
    mSwipeRefreshLayout.setRefreshing(true);
    if(mExampleList != null)
      mExampleList.clear();
     parseJSON();
    }