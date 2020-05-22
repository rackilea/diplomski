ArrayList frag;

public PagerAdapter(FragmentManager fm, int mNumOfTabs,ArrayList frag) {
    super(fm);
    this.mNumOfTabs = mNumOfTabs;
    this.frag = frag;
}