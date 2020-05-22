public class NavigationDrawerFragment extends Fragment {
    private static final String ARG_KEY_INIT_DATA = "init_data";

    public static NavigationDrawerFragment createInstance(ArrayList initData) {
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_KEY_INIT_DATA, initData);
        NavigationDrawerFragment frag = new NavigationDrawerFragment();
        frag.setArguments(args);
        return frag;
    }
    ...
}