@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment, parent, false);

    tvTextView = (TextView) v.findViewById(R.id.tvTextView);
    registerForContextMenu(tvTextView);

    String tvText =  tvTextView.getText().toString();

// I set the text
    setText(tvText);