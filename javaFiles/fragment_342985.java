@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

    }

      @Override
      public void onNavigationDrawerItemSelected(int position) {
         PlaceholderFragment placeholderFragment = new PlaceholderFragment();

         getSupportFragmentManager().beginTransaction()
            .replace(R.id.container, placeholderFragment.newInstance(position)).commit();
      }