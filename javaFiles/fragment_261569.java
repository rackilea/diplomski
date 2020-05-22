private SectionsPagerAdapter mSectionsPagerAdapter;

private ViewPager mViewPager;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

    mViewPager = (ViewPager) findViewById(R.id.container);
    mViewPager.setAdapter(mSectionsPagerAdapter);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

    mViewPager.addOnPageChangeListener(
            new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.addOnTabSelectedListener(
            new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
}

@Override
public void onFragmentOneInteraction(String string)
{
    fragmentTwo.onUpdateEditText(string);

    /*FragmentTwo fr2 = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.fr2);
    fr2.onUpdateEditText(string);*/
}

@Override
public void onFragmentTwoInteraction(Uri uri)
{
}

FragmentTwo fragmentTwo = new FragmentTwo();

public class SectionsPagerAdapter extends FragmentPagerAdapter
{

    public SectionsPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                FragmentOne fragmentOne = new FragmentOne();
                return fragmentOne;

            case 1:

                return fragmentTwo;

            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        // Show 2 total pages.
        return 2;
    }
}