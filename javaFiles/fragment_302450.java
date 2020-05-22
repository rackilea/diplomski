final SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeToRefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myWebView.reload(); // refreshes the WebView

                if (null != swipeLayout) {
                    swipeLayout.setRefreshing(false);
                }
            }
        });