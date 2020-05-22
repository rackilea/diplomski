class MyAdapter extends FragmentPagerAdapter {
private final int[] titles = {R.string.main_activity_title, R.string.join_activity_title};
private final String[] fragments = {
    MainFragment.class.getName(),
    JoinFragment.class.getName()
    };
private final Context ctx;

public MyAdapter(FragmentManager fm, Context ctx) {
    super(fm);
    this.ctx = ctx;
    }

@Override
public CharSequence getPageTitle(int position) {
    return ctx.getString(titles[position]);
    }

@Override
public Fragment getItem(int position) {
    return Fragment.instantiate(ctx, fragments[position]);
    }

@Override
public int getCount() {
    return titles.length;
    }
}