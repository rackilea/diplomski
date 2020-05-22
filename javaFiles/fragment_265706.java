@Override
protected View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment, null);

    Button btnValidate=(Button)v.findViewById(R.id.validate_code);
    btnValidate.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            //Functionality
        }
    });

    return v;
}