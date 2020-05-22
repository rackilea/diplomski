public class MyPagerAdapter extends FragmentPagerAdapter
{
    private Context context;
    final LatLng    YEREVAN = new LatLng(40.181, 44.513);

    public MyPagerAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new MyFragment();
            case 1:
                return MyMapFragment.newInstance(YEREVAN);
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        Locale l = Locale.getDefault();
        switch (position)
        {
            case 0:
                return context.getString(R.string.start).toUpperCase(l);
            case 1:
                return context.getString(R.string.map).toUpperCase(l);
        }
        return null;
    }
}