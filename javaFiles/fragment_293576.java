@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    Button b2 = (Button) view.findViewById(R.id.encb);
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // click related code goes here
        }
    });
    return view;
}