protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = mDrawerTitle = getTitle();
        setSupportActionBar(toolbar);
///it is required code
    if (savedInstanceState == null) {
        Fragment fragment = null;
        Class fragmentClass = null;
        fragment = new Fragmentforslider();
      fragmentClass= FragmentOne.class;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    }

    drawer = (DrawerLayout) findViewById(R.id.drawer_layout);