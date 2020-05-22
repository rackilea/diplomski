public class TabFragment extends Fragment {
public static TabLayout tabLayout;
public static NonSwipeableViewPager viewPager; // This line changed
public static int int_items = 2 ;

@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


    View x =  inflater.inflate(R.layout.tab_layout,null);
    tabLayout = (TabLayout) x.findViewById(R.id.tabs);
    viewPager = (NonSwipeableViewPager) x.findViewById(R.id.viewpager); // This line changed

    viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        public void onPageScrollStateChanged(int state) {}
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}



    tabLayout.post(new Runnable() {
        @Override
        public void run() {
            tabLayout.setupWithViewPager(viewPager);
        }
    });

    return x;

}