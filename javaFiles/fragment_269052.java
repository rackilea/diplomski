public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ListViewAdaptor mAdapter;
    private List<Data> mDataList = new ArrayList<>();

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ListViewAdaptor(mDataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        prepareList();
    }

    public void prepareList(){
       Data data = new Data("Item1","Price1",R.drawable.star);
        mDataList.add(data);
        data = new Data("Item2","Price2",R.drawable.star);
        mDataList.add(data);
        data = new Data("Item3","Price3",R.drawable.star);
        mDataList.add(data);
        data = new Data("Item4","Price4",R.drawable.star);
        mDataList.add(data);
        data = new Data("Item5","Price5",R.drawable.star);
        mDataList.add(data);
    }

}