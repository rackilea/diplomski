public class ViewPagerPagerAdapter extends FragmentPagerAdapter {

private double mLattitude;
public ViewPagerPagerAdapter (double lattitude) {
    this.mLattitude = lattitude;
}

//Now use that mLattitude wherever you want

public Fragment getItem(int position) {
            if (position == 0) {
                return new Fragment1();
            } else if (position == 1) {
                return new Fragment2();
            } else {
                Fragment3 fragment3 = new Fragment3();
                Bundle args = new Bundle();
                args.putDouble(fragment3.ARG_PARAM1, mLattitude);
                Log.d("WHATEVER", "WHATEVER: " + String.valueOf(mLattitude));
                fragment3.setArguments(args);
                return fragment3;
            }
        }
}