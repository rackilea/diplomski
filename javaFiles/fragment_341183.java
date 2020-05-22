@Override

public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

   View v = inflater
            .inflate(R.layout.fragment_breakfast, container, false);

  addListenerOnButton(v);
  ...........
  ..........
 }