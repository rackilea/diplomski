public class PagerAdapter extends FragmentStatePagerAdapter {
 public int mNumOfTabs;

public PagerAdapter(FragmentManager fm, int NumOfTabs) {
    super(fm);
    this.mNumOfTabs = 3;
}

@Override
public Fragment getItem(int position) {

    switch (position) {
        case 0:
            CollectionsFragment tab1 = new CollectionsFragment();
            return tab1;
        case 1:
            LoyaltyFragment tab2 = new LoyaltyFragment();
            return tab2;
        case 2:
            OrdersFragment tab3 = new OrdersFragment();
            return tab3;
        default:
            return null;
    }
}

@Override
public int getCount() {
    return mNumOfTabs;
}}