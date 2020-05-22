@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (findViewById(R.id.detailsConatiner) != null) {
        mTwoPane = true;
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.detailsConatiner, new MoviesDetailFragment(), DETAILFRAGMENT_TAG)
                .commit();
    } else mTwoPane = false;
  }
}