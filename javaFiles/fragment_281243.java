@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_blank, container, false);
    myTextView = (TextView) v.findViewById(R.id.fragmentTextView_id);
    String text = getArguments().getString("TextTag", "");
    myTextView .setText(text);
    return (v);
}