public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> mAllItemIds;

    public MyPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mAllItemIds = ...
    }

    @Override
    public int getCount() {
        return mAllItemIds.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.newInstance(mAllItemIds.get(position));
    }

    public void removeItem(int position) {

        // add needed code here to remove item also from source
        // ...

        mAllItemIds.remove(position);
        notifyDataSetChanged();
    }
}