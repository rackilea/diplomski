public class TabAdapter extends FragmentPagerAdapter {

final int PAGE_COUNT = 2;
private Context mContext;

public TabAdapter(Context context, FragmentManager fm) {
    super(fm);
    mContext = context;
}