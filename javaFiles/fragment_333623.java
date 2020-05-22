public abstract class PagingActivity extends AppCompatActivity {

    protected ViewPager mViewPager;
    MyPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        mViewPagerAdapter = new MyPagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    private void deleteItem() {
        mViewPagerAdapter.removeItem(mViewPager.getCurrentItem());
    }
}