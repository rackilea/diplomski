private RecyclerView mTaskList;
private DatabaseReference mDatabase;
private FirebaseRecyclerAdapter<Task, TaskViewHolder> adapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mTaskList = findViewById(R.id.task_list);
    mTaskList.setLayoutManager(new LinearLayoutManager(this));
    mDatabase = FirebaseDatabase.getInstance().getReference().child("Tasks");

    FirebaseRecyclerOptions<Task> options = new FirebaseRecyclerOptions.Builder<Task>()
        .setQuery(mDatabase, Task.class)
        .build();

    adapter = new FirebaseRecyclerAdapter<Task, TaskViewHolder>(options) {
        @Override
        protected void onBindViewHolder(TaskViewHolder holder, int position, Task model) { }

        @Override
        public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { }
    };
    mTaskList.setAdapter(adapter);
}