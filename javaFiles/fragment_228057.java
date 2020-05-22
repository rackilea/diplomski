@Override
public Fragment getItem(int position) {
    switch (position) {
    case 0:
       return new FragmentFavorites();
    case 1:
       return new FragmentCategories();
    case 2:
       return new FragmentYellowPages();
    }
    return null;
}

@Override
public int getCount() {
    return 3;
}