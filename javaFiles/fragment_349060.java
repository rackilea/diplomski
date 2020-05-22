@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
  View view = inflater.inflate(R.layout.fragment_information_list, container, false);
  unbinder = ButterKnife.bind(this, view);

  ListItem[] exercises = {
        new ListItem("1. Tell me about memory", ""),
        new ListItem("2. What can go wrong with my memory", ""),
        new ListItem("3. Helpful tips to improve my memory", "")
  };
  // rest of your code