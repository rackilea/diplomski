Buttom button
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_whats_hot, container, false);
    button = button = (Button)getView()findViewById(R.id.buttonSubmit);
    // similarly for other views 
    return rootView;
}