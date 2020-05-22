mSwipeRefreshLayout.post(new Runnable() {
                                         @Override
                                         public void run() {

                                             mSwipeRefreshLayout.setRefreshing(true);
                                             mExampleList.clear();
                                             mExampleAdapter.notifyDataSetChanged();
                                             parseJSON();
                                         }
                                     }
            );