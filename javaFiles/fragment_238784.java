private void init(Context context) {
    View view = inflate(context, R.layout.listview_item, this);
    view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    ViewPager viewPager;
    CustomPagerAdapter adapter;
    viewPager = (ViewPager) findViewById(R.id.view_pager);
    adapter = new CustomPagerAdapter(context);

    PagerAdapter wrappedAdapter = new InfinitePagerAdapter(adapter);
    viewPager.setAdapter(wrappedAdapter);

    //Hide the button unless showing image
    final Button selectButton = (Button) findViewById(R.id.selectButton);
    selectButton .setVisibility(GONE);

    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
             if(position==0)
                selectButton.setVisibility(View.GONE);
             else
                selectButton.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });


}