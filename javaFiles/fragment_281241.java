//Declare a member to hold a reference to your TextView
private TextView  myTextView;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_blank, container, false);
    myTextView = (TextView) v.findViewById(R.id.fragmentTextView_id);
    myTextView .setText("Whatever text you want");
    return (v);
}

//Also declare a function to modify the text on your fragment
public void setCustomText(String str) {
    if (myTextView != null) {
      myTextView.setText(str);
    }
}