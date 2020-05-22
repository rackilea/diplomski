public void fillMyPagerAdapter()
{

    mChildFragments = new Hashtable<Integer,GxuBaseFragment>();
    int count = 0;

        MyFragment a = MyFragment.newInstance(Integer.toString(my.getId()),count);
        mChildFragments.put(count,a);
        count += 1;

    mViewPagerAdapter.setTabHolderScrollingContent(this);
    mPager.setAdapter(mViewPagerAdapter);
    mPagerSlidingTabStrip.setViewPager(mPager);
    mPagerSlidingTabStrip.setOnPageChangeListener(this);

}