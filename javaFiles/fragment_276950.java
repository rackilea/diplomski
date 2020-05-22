@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_library);

    if (savedInstanceState == null) {
        getFragmentManager().beginTransaction()
                //.add(R.id.container, new PlaceholderFragment()).commit();
                .add(R.id.container, new LibraryFragment()).commit();
    }
}