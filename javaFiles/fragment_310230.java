mPager.setOnPageChangeListener(new OnPageChangeListener() {


        @Override
        public void onPageScrollStateChanged(int arg0) { }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) { }

        @Override
        public void onPageSelected(int position) {
             this.position = position
        }

    });