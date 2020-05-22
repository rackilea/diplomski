PostStatePagerAdapter adapter = new                PostStatePagerAdapter(getSupportFragmentManager(), dataList);

        ViewPager viewPager = (ViewPager) findViewById(R.id.postPager); // defined in layout xml
        viewPager.setAdapter(adapter);
           // pass your clicked item index to this activity and set it as view pager's current item
        viewPager.setCurrentItem(index);