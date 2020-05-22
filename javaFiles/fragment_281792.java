public class StoreListActivity extends Activity {
    private List<Store> mStores;
    private StoreAdapter mStoreAdapter;
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list);
        mListView = (ListView) findViewById(R.id.store_listview);

            mStores = getTheStoresFromSomewhere();
        mStoreAdapter = new StoreAdapter(this, mStores);
        mListView.setAdapter(mStoreAdapter);
    }