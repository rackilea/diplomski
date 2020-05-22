private Map<Long, View> mWebViews = new HashMap<Long, View>();

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Long id = adapter.getItemId(i);
            if(mViews.contains(id))
               mWebView = mViews.get(id)
            else
               mWebView = createWebView();
        }
    });