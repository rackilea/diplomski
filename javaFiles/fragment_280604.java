@Override
    public void onPageSelected(int position) {
        if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
            mTabStrip.onViewPagerPageChanged(position, 0f);
            scrollToTab(position, 0);
        }
        for (int i = 0; i < mTabStrip.getChildCount(); i++) {
            mTabStrip.getChildAt(i).setSelected(position == i);
        }
        if (mViewPagerPageChangeListener != null) {
            mViewPagerPageChangeListener.onPageSelected(position);
        }
    }