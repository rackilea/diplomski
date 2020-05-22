@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.questionario, container, false);
        ok = (Button)view.findViewById(R.id.btQuestionario);
        // add click listener for Button here
        // do same for accessing other Views
        return view;
    }