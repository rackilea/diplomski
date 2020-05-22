@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

    ImageButton button = (ImageButton) rootView.findViewById(R.id.stundenplanbtn);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), Stundenplan.class);
            startActivity(intent);


        }
    });

    ImageButton button2 = (ImageButton) rootView.findViewById(R.id.vertretungsbtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Vertretungsplan.class);
                startActivity(intent);


            }
        });

    return rootView;

}