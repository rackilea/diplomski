@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


ExploreFragment exploreFragment = new ExploreFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.layoutContainer, exploreFragment).commit();



        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }