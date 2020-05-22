@Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_home, container, false);

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

        // start the asyncTask
        new PopulatingTask((MainActivity)getActivity()).execute();

        return view;
    }