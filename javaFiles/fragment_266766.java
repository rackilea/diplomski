public class SectionsPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;

    public SectionsPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        fragmentList = fragments;
    }

@Override
public int getCount() {
    return fragmentList.size();
}

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragmentList.get(position);        
        return fragment;
    }