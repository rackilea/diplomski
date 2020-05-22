@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ping, container, false);
        Button pingButton = (Button) view.findViewById(R.id.pingButton);
        pingText = (EditText) view.findViewById(R.id.editText);
        pingResult = (TextView) view.findViewById(R.id.textView);
        pingButton.setOnClickListener(this);

        return view;
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.pingButton:
                String value = pingText.getText().toString();
                boolean s = ping(value);
                if(s == true)
                {
                    pingResult.setText("Successful ping to " + value);
                } else {
                    pingResult.setText("Unsuccessful ping to " + value);
                }
                break;
        }
    }