@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment, container, false);
    b1 = (Button) v.findViewById(R.id.button);
    b1.setOnClickListener(this);
    b2 = (Button) v.findViewById(R.id.button2);
    b2.setOnClickListener(this);
    b3 = (Button) v.findViewById(R.id.button3);
    b3.setOnClickListener(this);
    return v;
}