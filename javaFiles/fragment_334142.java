@Override
public Fragment getItem(int position) {
    if (position == 0) {
        return MainFragment.newInstance();
    } else {
        return SomeOtherFragment.newInstance();
    }

}