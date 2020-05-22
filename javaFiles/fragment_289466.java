myViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            // when user do a swipe the selected tab change
            myTabHost.setSelectedNavigationItem(position);
        }
    });

    //set titles
    for (int i = 0; i < myAdapter.getCount(); i++) {
        myTabHost.addTab(
                myTabHost.newTab()
                        .setText(myAdapter.getPageTitle(i))
                        .setTabListener(this)
        );
    }