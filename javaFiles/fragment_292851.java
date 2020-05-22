@Override
public Fragment getItem(int position) {
    try {
        switch (position) {
            case 0: {
                MapsFragment mapsActivity=new MapsFragment();
                return mapsActivity;
            }
            case 1: {
               Deals deals = new Deals();
               Bundle bundle = new Bundle();
               bundle.putStringArray("name", check);
               deals.setArguments(bundle);
               return deals;
            }
        }
    }
    catch ( Exception e)
    {
        Log.i("okkk", "Exception 1 : " + e);
    }