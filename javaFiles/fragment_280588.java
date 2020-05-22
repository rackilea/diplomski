@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    String strtext = getArguments().getString("KEY");    
    return inflater.inflate(R.layout.fragment, container, false);
}