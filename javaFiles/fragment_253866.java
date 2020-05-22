int margin = getResources().getDisplayMetrics().widthPixels / 15;
    mPager = (ViewPager) findViewById(R.id.pager);

    mPager.setPageMargin(margin);
    mPager.setPageMarginDrawable(R.drawable.shadow);
    mPager.setPageTransformer(true, new StackTransformer());