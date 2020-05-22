@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mRecyclerView = findViewById(R.id.recycler_view);
    mRecyclerView.setHasFixedSize(true);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setHasFixedSize(true);

    mExampleList = new ArrayList<>();
    mRecyclerView.setAdapter(new ExampleAdapter(mExampleList, some arguments)

    mRequestQueue = Volley.newRequestQueue(this);
    parseJSON();
}