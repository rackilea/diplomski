private Runnable runSlideshow = new Runnable() {
        public void run() {
            // Second parameter of false turns ViewPager scroll animation off
            mPager.setCurrentItem(mPager.getCurrentItem() + 1, false);
            mSlideshowHandler.postDelayed(runSlideshow,
                SLIDESHOW_IMAGE_DURATION);
    }
};