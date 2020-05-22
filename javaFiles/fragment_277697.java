public class HomePageActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private ActionBar ab;

    private boolean isDetail = false;
    private int lastSelected = 0;

    @Override
    protected void onResume() {
        super.onResume();

        if(mDrawerToggle != null) {
            mDrawerToggle.syncState();
        }

//        if(navigationView != null){
//            navigationView.getMenu().getItem(0).setChecked(true);
//        } else{
//            initDrawer();
//            navigationView.getMenu().getItem(0).setChecked(true);
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        initActionBar() ;
        initDrawer();

//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        PreferitiFragment fragment = new PreferitiFragment();
//        fragmentTransaction.add(R.id.content_frame, fragment);
//        fragmentTransaction.commit();

        mDrawerToggle.syncState();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        DrawerLayout drawer = (DrawerLayout) inflater.inflate(R.layout.drawer_layout, null);

        // HACK: "steal" the first child of decor view
        ViewGroup decor = (ViewGroup) getWindow().getDecorView();
        View child = decor.getChildAt(0);
        decor.removeView(child);
        FrameLayout container = (FrameLayout) drawer.findViewById(R.id.content_frame); // This is the container we defined just now.
        container.addView(child);
        decor.addView(drawer);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private void initActionBar() {
        ab = getSupportActionBar();
        if (ab == null) {
            Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
            return;
        }
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);


    }

    private void initDrawer() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int id = item.getItemId();
                lastSelected = id;

//                switch (id){
//                    case R.id.nav_favorite:
//                        setFragment(new PreferitiFragment());
//                        break;
//
//                    case R.id.nav_search:
//                        setFragment(new CercaPaeseFragment());
//                        break;
//
//                    case R.id.nav_settings:
//                        setFragment(new ImpostazioniFragment());
//                        break;
//
//                    case R.id.nav_guida:
//                        setFragment(new GuidaFragment());
//                        break;
//                    default:
//                        setFragment(new PreferitiFragment());
//                        break;
//                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                android.R.drawable.ic_btn_speak_now,
                R.string.open,
                R.string.close
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                invalidateOptionsMenu();
//                mDrawerToggle.syncState();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
//                mDrawerToggle.syncState();
            }


        };
        drawerLayout.setDrawerListener(mDrawerToggle);
    }

//    @Override
//    public void showDetails(UUID idPharmacy) {
//
//        isDetail = true;
//        setFragment(new DettagliFragment());
//    }

//    @Override
//    public void onBackPressed() {
//        if (isDetail) {
//            if(lastSelected == R.id.nav_search) {
//                setFragment(new CercaPaeseFragment());
//            } else if(lastSelected == R.id.nav_favorite){
//                setFragment(new PreferitiFragment());
//            }
//        } else {
//            super.onBackPressed();
//        }
//    }

//    private void setFragment(Fragment fragment){
//
//
//        IMyFragments iMyFragments = (IMyFragments) fragment;
//        ab.setTitle(iMyFragments.getTitle());
//
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.content_frame, fragment);
//        fragmentTransaction.commit();
//    }
}