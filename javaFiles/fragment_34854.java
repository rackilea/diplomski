@Override
public void onNavigationDrawerItemSelected(int position) {
    if (position == mCurrentSectionID)
        return;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);

    Fragment dest;
    switch (position) {
        case BitsListFragment.FRAGMENT_ID:
            dest = fragmentManager.findFragmentByTag(BitsListFragment.class.getName());
            if (dest == null) {
                Log.d("TRANSACTION", "instanciating new fragment");
                dest = BitsListFragment.newInstance();
            }
            transaction.replace(R.id.container, dest, BitsListFragment.class.getName());
            transaction.addToBackStack(BitsListFragment.class.getName());
            break;
        case AchievementsFragment.FRAGMENT_ID:
            dest = fragmentManager.findFragmentByTag(AchievementsFragment.class.getName());
            if (dest == null) {
                Log.d("TRANSACTION", "instanciating new fragment");
                dest = AchievementsFragment.newInstance();
            }
            transaction.replace(R.id.container, dest, AchievementsFragment.class.getName());
            transaction.addToBackStack(AchievementsFragment.class.getName());
            break;
        case StatsFragment.FRAGMENT_ID:
            dest = fragmentManager.findFragmentByTag(StatsFragment.class.getName());
            if (dest == null) {
                Log.d("TRANSACTION", "instanciating new fragment");
                dest = StatsFragment.newInstance();
            }
            transaction.replace(R.id.container, dest, StatsFragment.class.getName());
            transaction.addToBackStack(StatsFragment.class.getName());
            break;
    }

    transaction.commit();
    onSectionAttached(position);
}