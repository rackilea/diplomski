public class ListFragmentViewPagerActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new ExamplePagerAdapter(getSupportFragmentManager()));
    }

    public class ExamplePagerAdapter extends FragmentPagerAdapter {

    public ExamplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new ExampleListFragment();

        // set arguments here, if required
        Bundle args = new Bundle();
        // args.put(...)
        fragment.setArguments(args);

        return fragment;
    }
    }
}