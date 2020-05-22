public class TabFragment extends Fragment {

private SlidingTabLayout mSlidingTabLayout;
private MyActivityAdapter mAdapter;
private ViewPager mViewPager;
private Menu mMenu;

private ScreenNames mScreenName = ScreenNames.UNRAVELING_ME;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_swipe, container, false);

    mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
    mSlidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);
    mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.unravel_secondary_red));
    mSlidingTabLayout.setDistributeEvenly(true);
    mSlidingTabLayout.setBackgroundColor(Color.parseColor("#F7F7F7"));

    mSlidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener (){

        @Override
        public void onPageSelected(int position)
        {
            if(position == 0){


            }
            else {

            }

        }
        @Override
        public void onPageScrollStateChanged(int state)
        {

        }
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
        {

        }
    });

    mViewPager = (ViewPager) view.findViewById(R.id.pager);
    mAdapter = new MyActivityAdapter(this, getChildFragmentManager());
    mViewPager.setAdapter(mAdapter);
    mSlidingTabLayout.setViewPager(mViewPager);
    return view;
}