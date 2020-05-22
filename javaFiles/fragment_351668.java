public class MyActivityAdapter extends FragmentPagerAdapter {

private MyActivityFragment mFragment;

public MyActivityAdapter(MyActivityFragment fragment, FragmentManager fm) {
    super(fm);
    mFragment = fragment;
}

@Override
public Fragment getItem(int i) {
    if (i == 0) {
        return new fragment1();
    }
    else {
        return new fragment2();
    }
}

@Override
public int getCount() {
    return 2;
}


@Override
public CharSequence getPageTitle(int position) {
    if (position == 0) {

        return "first tab";
    } else {

        return "second tab";
    }
}
}