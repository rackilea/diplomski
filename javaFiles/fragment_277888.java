public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private FilterManager filterManager;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(Context context, FragmentManager fm, 
               FilterManager filterManager) {
        super(fm);
        this.context = context;
        this.filterManager = filterManager;
    }

    @Override
    public Fragment getItem(int i) {
        NestedFragment fragment = new NestedFragment(); // see (*)
        filterManager.addObserver(fragment); // add the observer
        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        NestedFragment fragment = (NestedFragment) object; // see (*)
        filterManager.deleteObserver(fragment); // remove the observer
        super.destroyItem(container, position, object);
    }
}