ViewPager mPager; 

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mPager = (ViewPager) findViewById(R.id.view_pager);
}