public class MyActivity extends Activity{

    // ....

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);


        // init your views
        RecyclerView recyclerView = findViewById(R.id.recycler_view);


        // here you can pull or generate your recycler view list data
        List<MyModel> data = getData();
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(data);


        // set layout manager to the recycler view (Required)
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 
                                                        LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // set the adapter to the recycler view (Required)
        recyclerView.setAdapter(adapter);
    }

    // ....
}