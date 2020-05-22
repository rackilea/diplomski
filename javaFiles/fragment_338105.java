public class GameListPagerAdapter extends FragmentPagerAdapter {

    GameList _games;
    public int int_items = 6 ;

    public GameListPagerAdapter(FragmentManager fm, GameList _games) {
        super(fm);
        this._games = _games;
    }

    @Override
    public Fragment getItem(int position)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("GameId", position);
        MatchListFragment matchListFragment = new MatchListFragment();
        matchListFragment.setArguments(bundle);

        return matchListFragment; // always return the same fragment, just give it a different game id
    }

    @Override
    public int getCount() {
        return int_items;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return _games.get(position);
    }
}