mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                case 0:
                    fab.hide();
                    break;
                case 1:
                    fab.show();
                    break;
                case 3:
                    fab.hide();
                    break;
                default:
                    fab.hide();
                    break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });