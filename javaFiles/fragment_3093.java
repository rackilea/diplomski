viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(position == 3){
                //that means 4th tab
                //show the popup
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });