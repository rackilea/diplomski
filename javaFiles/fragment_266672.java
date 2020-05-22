public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    WeatherListAdapter mAdapter;
    List<WeatherData> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<>();
        // Just a bunch of sample data we're using to populate the RecyclerView
        mList.add(new WeatherData("Sacramento", "88", "60"));
        mList.add(new WeatherData("Dallas", "96", "40"));
        mList.add(new WeatherData("Orlando", "80", "85"));
        mList.add(new WeatherData("Seattle", "68", "78"));

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // In your WeatherListAdapater class you pass a List to the constructor, this is the
        // list that contains all the WeatherData and the list we use to add new CardViews.
        mAdapter = new WeatherListAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Adding a new item to our WeatherData list with the FAB
                // This item will become a new CardView
                // We can similarly remove CardViews by calling remove()
                mList.add(new WeatherData("Boston", "67", "50"));
                // Updating the UI after adding the CardView so it shows up
                updateUI();
            }
        });
    }

    private void updateUI() {
        // The list we passed to the mAdapter was changed so we have to notify it in order to update
        mAdapter.notifyDataSetChanged();
    }

}