Context mContext;
public ViewPagerAdapter(Context context, FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
    super(fm);
    this.mContext = context;
    this.Titles = mTitles;
    this.NumbOfTabs = mNumbOfTabsumb;

}