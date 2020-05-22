public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState == null) {
        // Add the fragment on initial activity setup
        mainFragment = new Fragment();
        getSupportFragmentManager().beginTransaction()
        .add(android.R.id.content, mainFragment).commit();
    } else {
        // Or set the fragment from restored state info
        mainFragment = (Fragment) getSupportFragmentManager()
                .findFragmentById(android.R.id.content);
    }

}