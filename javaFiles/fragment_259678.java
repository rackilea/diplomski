public class ViewPagerFragmentActivity extends FragmentActivity {
    /** maintains the pager adapter*/
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.viewpager_layout);
        String buttonId = getIntent().getStringExtra("buttonID");//call this line get button id from BrowseStyle Activity
        // initialize the pager
        FragmentStyleSubCatMain.mButtonId = (int) buttonId;// set your button Id like this
        this.initializePaging();
    }


}