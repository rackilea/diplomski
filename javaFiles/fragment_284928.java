private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    int layouts[];
    public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
        layouts=new int[]{R.layout.fragment_slide_screen_page1,R.layout.fragment_slide_screen_page2,R.layout.fragment_slide_screen_page3,R.layout.fragment_slide_screen_page4,R.layout.fragment_slide_screen_page5};
    }

    @Override
    public Fragment getItem(int position) {

        ScreenSlidePageFragment fragment=new ScreenSlidePageFragment();
        fragment.setContent(layouts[position]);
        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}