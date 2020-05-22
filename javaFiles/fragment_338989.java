public class ViewPagerUnitDetailsAdapter extends FragmentPagerAdapter {

     private final String unitID;

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerUnitDetailsAdapter (FragmentManager manager) {
        super(manager);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String unitID) {
        mFragmentList.add(fragment);
        this.unitID = unitID;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){           
            return FragmentReportHauls.newInstance(this.unitID);
        }
        else {
            return FragmentReportsDowntime.newInstance(this.unitID);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return FragmentReportHauls.PAGE_TITLE;
        }
        else {
            return FragmentReportsDowntime.PAGE_TITLE;
        }
    }
}