public class PageAdapter extends FragmentStatePagerAdapter {
int mNumOfTabs;

public PageAdapter(FragmentManager fm, int NumOfTabs) {
    super(fm);

    this.mNumOfTabs = NumOfTabs;
}

@Override
public Fragment getItem(int position) {

    switch (position) {
        case 0:
            Fragment tab1 = new Fragment(); //When click First tab 
            return tab1;
        case 1:
            Fragment2 tab2 = new Fragment2(); //When click on second tab
            return tab2;
        default:
            return null;
    }
}

@Override
public int getCount() {

    Log.i("tag1","on getcount");
    return mNumOfTabs;
                    }
}