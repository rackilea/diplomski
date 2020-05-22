public class TabPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList;

    public FragmentsPagerAdapter(FragmentManager fragmentManager) {
    super(fragmentManager);
    fragmentList = new ArrayList<>();
    fragmentList.add(new FirstTab());
    fragmentList.add(new SecondTab());
    fragmentList.add(new ThirdTab());
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_UNCHANGED;
    }
}