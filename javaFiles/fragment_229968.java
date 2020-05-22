@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = findViewById(R.id.recycler);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);
    backgroundTask = new BackgroundTask(this, new Listener() {
        @Override
        public void onDataReceived(ArrayList<Info> list) {
            thugAdapter = new ThugAdapter(list);
            recyclerView.setAdapter(thugAdapter);
        }

        @Override
        public void onError(int error) {

        }
    });
    backgroundTask.getArrayList();
}