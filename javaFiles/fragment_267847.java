//activity onCreate()
protected void onCreate(Bundle savedInstanceState) {
    ...
    mTextView = (TextView) findViewById(R.id.text_view);
    mViewPager = (ViewPager) findViewById(R.id.pager);
    mViewPager.setAdapter(mPagerAdapter);
    mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
                String someText = determineText(position)
                mTextView.setText(someText);

    });

    //because onPageSelected will not be called for page 0 first time
    String someText = determineText(0)
    mTextView.setText(someText);
}

private String determineText(int position){ //static?
    //switch?
}