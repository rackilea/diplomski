@Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      BottomNavigationView navigation = findViewById(R.id.navigation);
     navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

// This is a way to hide static menu item
      navigation.getMenu().removeItem(R.id.navigation_home);
      ...
    }