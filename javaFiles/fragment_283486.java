public class MyListFragment extends Fragment {

  private static String ARG_URL = "url";

  public static MyListFragment create(String url) {
    Bundle args = new Bundle();
    args.putString(ARG_URL, url);
    MyListFragment fragment = new MyListfragment();
    fragment.setArguments(args);
    return fragment;
  }

  ...
}