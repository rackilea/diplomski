viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                   //Get current fragment and update UI
                   BaseFragment fragment= (BaseFragment) fragmentPagerAdapter.getItem(position);
                //assumes updateUI ,a method in BaseFragment is overriden in Fragment implementation to update UI.You can place your logic here.
                fragment.updateUI();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });