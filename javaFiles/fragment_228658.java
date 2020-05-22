@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // das Layout fuer dieses Fragment laden
        View view= inflater.inflate(R.layout.fragmenta, container, false);
        // inflate layout
        Button notfallbtn = (Button) view.findViewById(R.id.notfallbtn);
        // initialize button using the inflated view object
        notfallbtn.setOnClickListener(this);
        // listener for button
        return view;   // return inflated view
    }