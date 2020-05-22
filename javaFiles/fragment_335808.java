public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.point_creation, container, false);
        final EditText SerialField = (EditText) view.findViewById(R.id.Serial);
        final EditText ObservationField = (EditText) view.findViewById(R.id.Observation);
        Button buttonGuardar = (Button) view.findViewById(R.id.buttonGuardar);
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "tou a carregar no botao guardar", Toast.LENGTH_LONG).show();
                String Serial = SerialField.getText().toString();
                String Observation = ObservationField.getText().toString();
                pointsList.add(new Point("Serial", Observation, false, 1, 2, 3, 4,
                        5, 6, 7, 8, 9));
                Toast.makeText(getActivity().getApplicationContext(), Observation, Toast.LENGTH_LONG).show();
            }
        });
        Button buttonApagar = (Button) view.findViewById(R.id.buttonApagar);
        buttonApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "tou a carregar no botao apagar", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }