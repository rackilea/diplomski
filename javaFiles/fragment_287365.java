PullToRefreshListView listview;

listview = (PullToRefreshListView) findViewById(R.id.airpost_listView);

    listview.setOnRefreshListener(new OnRefreshListener() {
        public void onRefresh() {
            // TODO Auto-generated method stub
            new GetPost().execute(); // AsyncTask where you can put your  logic when to call the listview for getting new data or let it be same as before
        }
    });