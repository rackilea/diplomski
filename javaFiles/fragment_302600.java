@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {        

    View rootView = inflater.inflate(R.layout.fragment_kereta_api, container, false);

    Button pilihka = (Button) rootView.findViewById(id.btnpilihdgnka);

    pilihka.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {       
            Intent i = new Intent(getActivity(), PilihDenganKA.class);
            startActivity(i);
        }
    });

    return rootView;
}