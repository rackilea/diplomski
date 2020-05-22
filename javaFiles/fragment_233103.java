public class YourFragment Fragment{

    public static YourFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, id);
        YourFragment fragment = new YourFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }
}