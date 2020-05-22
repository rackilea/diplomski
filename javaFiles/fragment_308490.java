public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_subscription, container, false);
        mainLinear = (LinearLayout) rootView.findViewById(R.id.HolderLayout);
        createEdittext = (Button) rootView.findViewById(R.id.CreateEdittext);
         .......
        return rootView;
    }