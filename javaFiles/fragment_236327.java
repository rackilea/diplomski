public class DetailedFragment extends DialogFragment {

    private static final String ARG_SHOW_AS_DIALOG = "DetailedFragment.ARG_SHOW_AS_DIALOG";

    public static DetailedFragment newInstance(boolean showAsDialog) {
        DetailedFragment fragment = new DetailedFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_SHOW_AS_DIALOG, showAsDialog);
        fragment.setArguments(args);
        return fragment;
    }

    public static DetailedFragment newInstance() {
        return newInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            setShowsDialog(args.getBoolean(ARG_SHOW_AS_DIALOG, true));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detailed_fragment, container, false);
    }
}