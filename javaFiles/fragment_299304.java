public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {


    View view =inflater.inflate(R.layout.meat_adobo, container, false);
    Button cca = (Button) view.findViewById(R.id.cca);

    cca.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

       }
    });
    return view;
}