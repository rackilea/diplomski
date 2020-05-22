@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);


    rootView.findViewById(R.id.stundenplanbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Stundenplan.class);
                startActivity(intent);


            }
        });

    rootView.findViewById(R.id.vertretungsbtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Vertretungsplan.class);
                    startActivity(intent);


                }
            });

 return rootView;

}