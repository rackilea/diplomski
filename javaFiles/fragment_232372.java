public interface FavoriteManager {
  void onFavoriteAdded(Station s);
  void onFavoriteRemoved(Station s);
  List<Station> getFavorites();
  etc.
}

public class MainActivity extends FragmentActivity implements FavoriteManager {
  ...
  private List<Station> mFavorites;
  ...
  @Override
  public void onFavoriteAdded(Station s) {
    mFavorites.add(s);
  }
  ...
  @Override
  public List<Station> getFavorites() {
    return mFavorites;
  }
}

public class FavoritesFragment extends Fragment {
  ...
  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    Station s = (Station) l.getItemAtPosition(position);

    FavoriteManager manager = (FavoriteManager) getActivity();
    manager.onFavoriteAdded(s);

    getFragmentManager().popBackStack();
  }
  ...
}

public class MyListFragment extends Fragment {
  ...
  @Override
  public void onStart() {
    List<Station> favorites = ((FavoriteManager) getActivity()).getFavorites();
    populateUi(favorites);
  }
  ...
}