MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
    Resources resources = this.getResources();
    mainPagerAdapter.addFragment(fragmentOne, "fragmentOneTitle");
    mainPagerAdapter.addFragment(fragmentTwo, "fragmentTwoTitle");

    mViewPager.setAdapter(mainPagerAdapter);