View main_view;

@Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    main_view = inflater.inflate(R.layout.your_fragment, container,false);
    firstTextview = (TextView) main_view.findViewById(R.id.myFirstText);

    secondTextview = (TextView) main_view.findViewById(R.id.mysecondText);