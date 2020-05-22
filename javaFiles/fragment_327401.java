class myPagerAdapter extends FragmentPagerAdapter {
    private String mItem;
    public myPagerAdapter(FragmentManager fm, String item) {
        super(fm);
        mItem = item;
    }