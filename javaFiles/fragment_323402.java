private final Activity mContext;
private final Fragment[][] mFragment;

public MyGridViewPagerAdapter(Activity ctx, FragmentManager fm, Fragment[][] fragments)
{
  super(fm);
  mContext = ctx;
  this.mFragment = fragments;
}