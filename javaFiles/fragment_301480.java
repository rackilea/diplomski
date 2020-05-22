//global in your adapter:
private Fragment[] fragments;

public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new GameFragment[4];
        fragments[0] = new MyFragment();
        fragments[1] = new SecondFragment();
        ....
    }
    public Fragment getItem(int position) {
       return fragments[position];
    }

    public Fragment getFragment(int position) {
       return fragments[position];
    }