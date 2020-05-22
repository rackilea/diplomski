public class FragmentTwo extends Fragment {
    View rootview;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_two, container, false);

        MainActivity activity = (MainActivity) getActivity();
        activity.listview()

        return rootview;
    }
}