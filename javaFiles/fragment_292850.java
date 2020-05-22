@Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: {
                MapsFragment mapsActivity=new MapsFragment();
                return mapsActivity;
            }
            case 1: {
                return deals;
            }
       }
    return null;
}