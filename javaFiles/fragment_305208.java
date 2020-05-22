public class MovieListActivityTEST extends AppCompatActivity {

ViewPager pager;
ViewPagerAdapter adapter;
SwipeRefreshLayout refreshLayout;
SlidingTabLayout tabs;
CharSequence Titles[]={"Home","Events"};
int Numboftabs =2;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_list_activity_test);

    // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
    adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

    // Assigning ViewPager View and setting the adapter
    pager = (ViewPager) findViewById(R.id.pager);
    pager.setAdapter(adapter);

    // Assiging the Sliding Tab Layout View
    tabs = (SlidingTabLayout) findViewById(R.id.tabs);
    tabs.setDistributeEvenly(true); 

    // Setting Custom Color for the Scroll bar indicator of the Tab View
    tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
        @Override
        public int getIndicatorColor(int position) {
            return getResources().getColor(R.color.tabsScrollColor);
        }
    });

    // Setting the ViewPager For the SlidingTabsLayout
    tabs.setViewPager(pager);

    // Assign your refresh layout
    refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

    refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Refreshable r = (Refreshable) adapter.getItemAt(pager.getCurrentItem());
            r.refresh();
        }
    }); 
}