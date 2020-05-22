@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_sounds, container, false);
    Button button1=(Button)rootView.findViewById(R.id.button_1);
    Button button2=(Button)rootView.findViewById(R.id.button_2);
    button1.setOnClickListener(this);
    button2.setOnClickListener(this); 
    return rootView;
}