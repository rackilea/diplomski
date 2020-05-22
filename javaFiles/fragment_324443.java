private TextView text;

  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        text = (TextView) myFragmentView.findViewById(R.id.text);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_fragment, container, false);


    }