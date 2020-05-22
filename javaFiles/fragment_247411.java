public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.line_details, container, false);

        TextView LT = (TextView) myInflatedView.findViewById(R.id.textViewLineType);
        Button InfoButton = (Button) myInflatedView.findViewById(R.id.buttonViewDetails);
        InfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VerifyLine.class);
                startActivity(intent);
            }
        });

        Bundle extras = getArguments();
        if (extras != null) {
            String linetype = extras.getString("LineType");
            LT.setText(linetype);
        }

        return myInflatedView;
    }