ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrollStateChanged(int arg0) { }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) { }

    @Override
    public void onPageSelected(int position) {

        switch (position) {
        case 0: 
             drawerGrid.setVisibility(View.GONE);
            break;

        case 1:
            drawerGrid.setVisibility(View.VISIBLE);
            break;
        default:
            break;
        }
    }
});