public class MainActivity extends FragmentActivity {

SectionsPagerAdapter mSectionsPagerAdapter;

ViewPager mViewPager;

List<Fragment> mFragments;


@Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

 mFragments = new ArrayList<Fragment>();
 mFragments.add(new DummySectionFragment();
 mFragments.add(new DummyListFragment();

  mSectionsPagerAdapter = new SectionsPagerAdapter(
        getSupportFragmentManager(), mFragments);