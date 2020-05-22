SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
         mExampleList.clear()
         parseJSON();
        }
    });
    mExampleList = new ArrayList<>();
    mRequestQueue = Volley.newRequestQueue(this);
    parseJSON();
}