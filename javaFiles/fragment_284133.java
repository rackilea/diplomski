@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_connect, container, false);
    Button aButton = (Button) rootView.findViewById(R.id.button_id);

    return rootView;
}