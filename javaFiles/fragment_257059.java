public class TimelineActivity extends AppCompatActivity {
    private PostTweetDialog PostDialog;
    private RestClient client;
    private ArrayList<Tweet> Tweet;
    private TweetArrayAdapter taAdapter;
    private RecyclerView rvItems;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_tab_favourite,
            R.drawable.ic_tab_call,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        rvItems = (RecyclerView) findViewById(R.id.rvItems);
        Tweet = new ArrayList<>();
        taAdapter = new TweetArrayAdapter(Tweet);
        rvItems.setAdapter(taAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        client = RestApplication.getRestClient();
        PostDialog = new PostTweetDialog(client);

        ...
     }
     ...
 }