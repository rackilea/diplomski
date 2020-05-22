public static ExampleFragment newInstance(String name, String location) {
             ExampleFragment myFragment = new ExampleFragment();
             Bundle args = new Bundle();
             args.putString("name", name);
             args.putString("location", location);
             myFragment.setArguments(args);

             return myFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String name = getArguments().getString("name");
        String location = getArguments().getString("location");
        Name.setText(name);
        Location.setText(location);