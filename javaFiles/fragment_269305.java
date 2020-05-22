private void ViewPagerInitialize()
 {
     List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, AndroidFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, AppleFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, MicrosoftFragment.class.getName()));
        mPageradapter  = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);
        mViewPager = (ViewPager)super.findViewById(R.id.pager);
        mViewPager.setAdapter(mPageradapter);
        mViewPager.setOnPageChangeListener(this);
 }    

 private static void AddTab(MainActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInformation tabInfo) 
 {
        tabSpec.setContent(new FragmentControl(activity));
        tabHost.addTab(tabSpec);
  }