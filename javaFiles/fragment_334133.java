@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_1, container, false);
    String strtext = this.getArguments().getString("sessionName");    
    TextView sessionTitle = (TextView) view.findViewById(R.id.session1);
    sessionTitle.setText(strtext);
    return view;
}