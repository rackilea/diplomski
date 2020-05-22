TabLayout tabLay = (TabLayout) findViewById(R.id.tabLayout);

    tabLay.addTab(tabLay.newTab().setText("Collections"));
    tabLay.addTab(tabLay.newTab().setText("Loyalty"));
    tabLay.addTab(tabLay.newTab().setText("Orders"));


    viewPager = (ViewPager) findViewById(R.id.userTabs);
    final PagerAdapter adapter = new PagerAdapter
            (getSupportFragmentManager(), tabLay.getTabCount());
    viewPager.setAdapter(adapter);

    tabLay.setupWithViewPager(viewPager);
    tabLay.getTabAt(0).setText("Collections");
    tabLay.getTabAt(0).setIcon(R.drawable.collage);
    tabLay.getTabAt(1).setText("Loyalty");
    tabLay.getTabAt(1).setIcon(R.drawable.heart_outline);
    tabLay.getTabAt(2).setText("Orders");
    tabLay.getTabAt(2).setIcon(R.drawable.cart_outline);




    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLay));



    tabLay.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });


}