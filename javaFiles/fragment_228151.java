@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.your_layout, container, false);
    TabHost tabHost = (TabHost) view.findViewById(R.id.profile_tabs);
    tabHost.setup();
    tabHost.addTab(...);
    tabHost.addTab(...);
    return view;
}