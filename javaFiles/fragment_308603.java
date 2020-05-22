mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    toolbar.setTitle(R.string.home);
                    break;
                case 1:
                    toolbar.setTitle(R.string.activities);
                    break;
                case 2:
                    toolbar.setTitle(R.string.people);
                    break;
                case 3:
                    toolbar.setTitle(R.string.posts);
                    break;
                case 4:
                    toolbar.setTitle(R.string.media);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {}
    });