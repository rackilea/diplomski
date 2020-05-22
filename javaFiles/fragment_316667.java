@Override
public Fragment getItem(int position) {
    // getItem is called to instantiate the fragment for the given page.
    switch (position) {
        case 0:
            return FragmentFirst.newInstance();
        case 1:
            return FragmentSecond.newInstance();
        case 2:
            return FragmentThird.newInstance();
        default:
            //assume you only have 3
            throw new IllegalArgumentException();
    }
}