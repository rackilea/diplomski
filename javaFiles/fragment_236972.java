private  void initialisePaging() {
    List<Fragment> fragments = new Vector<Fragment>();
    fragments.add(Fragment.instantiate(this,fragment1.class.getName()));
    fragments.add(Fragment.instantiate(this,fragment2.class.getName()));
    fragments.add(Fragment.instantiate(this,fragment3.class.getName()));

    //add this line
    Collections.shuffle(fragments , new Random(System.nanoTime()));

    PagerAdapter mPagerAdapter = new PagerAdapter(this.getSupportFragmentManager(), fragments);

    ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
    pager.setAdapter(mPagerAdapter);

}