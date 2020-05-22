public class PagerAdapter extends FragmentStatePagerAdapter {
int mNumOfTabs;

public PagerAdapter(FragmentManager fm, int NumOfTabs) {
    super(fm);
    this.mNumOfTabs = NumOfTabs;
}

@Override
public Fragment getItem(int position) {

    switch (position) {
        case 0:
            BidMainFragment bidMainFragment = new BidMainFragment();
            return bidMainFragment;
        case 1:
            BookMainFragment bookMainFragment = new BookMainFragment();
            return bookMainFragment;
        default:
            return null;
    }
}

@Override
public int getCount() {
    return mNumOfTabs;
}
}