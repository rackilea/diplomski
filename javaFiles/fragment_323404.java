@Override
protected void onCreate(Bundle savedInstanceState)
{
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_my);

  final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
  final Fragment[][] items = {
        {
                CusmtomFragment.newInstance("your","arguments"),
                CusmtomFragment.newInstance()
        },
        {
                OtherFragment.newInstance(),
                AnotherFragment.newInstance(1234)
        }
  };
  // ....
  pager.setAdapter(new MyGridViewPagerAdapter(this, getFragmentManager(), items));
}