public class MyFragmentedPagerAdapter extends FragmentStatePagerAdapter {
    private final TabLayout mTabLayout;
    private final SwipeRefreshLayout.OnRefreshListener mRefreshListener;
    private Vector<PriceListFragment> fragmentList;
    private Vector<String> titles;

    public MyFragmentedPagerAdapter(FragmentManager fm, MyComplexData data, OnCartActionListener listener, TabLayout tabLayout, SwipeRefreshLayout.OnRefreshListener refreshListener) {
        super(fm);
        mTabLayout = tabLayout;

        // external refresh listener, that will trigger an updateData() 
        mRefreshListener = refreshListener;

        fragmentList = new Vector<>();
        titles = new Vector<>();
        updateData(data);
    }

    public void updateData(MyComplexData data) {
        boolean updateTabs = false;
        boolean hasNewData = false;

        Vector<String> newTitles = new Vector<>();

        int position = 0;
        for(TabContents tabContents : data.getTabContents()) {

            if(tabContents.getListContents() == null)
                continue;
            hasNewData = true;
            boolean isNewFragment;

            MyFragment fragment;
            try {
                fragment = fragmentList.get(position);
                isNewFragment = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                fragment = new MyFragment();
                isNewFragment = true;
            }
            // Update the data, title and hide update indicator of SwipeRefreshLayout
            fragment.setTabContents(tabContents);

            newTitles.add(tabContents.getName());

            if(isNewFragment) {
                fragment.setRefreshListener(mRefreshListener);
                fragmentList.add(fragment);
            }
            position++;
        }

        if(!hasNewData)
            return;

        // we need to decide, whether to update tabs
        if(titles.size() != newTitles.size()) {
            updateTabs = true;
        } else {
            for(position = 0; position < titles.size(); position++) {
                if(!titles.get(position).equals(newTitles.get(position))) {
                    updateTabs = true;
                    break;
                }
            }
        }

        titles = newTitles;
        notifyDataSetChanged();

        if(updateTabs)
            mTabLayout.setTabsFromPagerAdapter(this);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    // You need to override this method as well
    @Override
    public int getItemPosition(Object object) {
        MyFragment fragment = (MyFragment) object;
        String title = (String) fragment.getTitle();
        int position = titles.indexOf(title);

        if (position >= 0) {
            return position;
        } else {
            return POSITION_NONE;
        }
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getTitle();
    }
}