@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    adapter = new MyRecyclerViewAdapter(MainActivity.this, new ArrayList<WallItem>());
    mRecyclerView.setAdapter(adapter);

    progressBar = (ProgressBar) findViewById(R.id.progress_bar);

    // Setup shared preferences
    setupSharedPreferences();

    // Load the recyclerView
    loadRecyclerView(savedInstanceState);

}