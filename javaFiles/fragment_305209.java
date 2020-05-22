public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    // list that keeps references to all attached Fragments
    private SparseArray<Fragment> pages = new SparseArray<>();
    ...

    public Fragment getItem(int position) {
        Fragment f;
        if(position == 0) {
            ...
        } else { ... }

        // add fragment to the list
        pages.put(position, f);
    }

     public void destroyItem(ViewGroup container, int position, Object object) {
        // remove fragment from list if it existed
        if(pages.indexOfKey(position) >= 0) {
            pages.remove(position);
        }

        super.destroyItem(container, position, object);
    }

    // return the attached Fragment that is associated with the given position
    public Fragment getItemAt(int position) {
        return pages.get(position);
    }
}