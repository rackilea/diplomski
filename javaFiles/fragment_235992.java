@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_display_message, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.displayText);
        String strtext = getArguments().getString("key");
        textView.setText(strtext);
        return rootView;
    }