@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
           feedListView= (ListView) findViewById(R.id.custom_list);
           String url = "...";
           new DownloadFilesTask().execute(url);
           feedListView.setAdapter(new CustomListAdapter(this, feedList));
}