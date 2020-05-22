public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Feed", "In Stock", "Upcoming" };

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        if (position==0) {
            return FeedFrag.newInstance(position + 1);
        } else if (position == 1) {
            return InStockFrag.newInstance(position + 1); 
        } else {
            //HERE RETURN SAME METHOD OF UPCOMING FRAGMENT
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}