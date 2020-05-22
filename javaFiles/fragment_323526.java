@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_googlemaptab, container, false);
        kakaobutton = (Button)view.findViewById(R.id.kakaobutton);

        mapview = (MapView)view.findViewById(R.id.google_map_view);
        setupAutoCompleteFragment(this);
        return view;
    }