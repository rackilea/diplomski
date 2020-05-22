@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(null);
    setContentView(R.layout.activity_main);

    FragmentManager fragmentManager = getFragmentManager();
    PlaceholderFragment placeholderFragment = new PlaceholderFragment();

    if (savedInstanceState == null) {
        fragmentManager.beginTransaction()
                .add(R.id.container, placeholderFragment).commit();
    }
}

public void anotherFunc() {

    PlaceholderFragment placeholderFragment = (PlaceholderFragment) fragmentManager
            .findFragmentById(R.id.container);
}