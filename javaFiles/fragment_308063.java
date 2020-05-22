public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

Fragment fragment;

SharedPreferences sharedPreferences;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);Toolbar toolbar = findViewById(R.id.toolbar);
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    NavigationView navigationView = findViewById(R.id.nav_view);
    View headerView = navigationView.getHeaderView(0);
    final TextView tvDrawerUsername = headerView.findViewById(R.id.tvDrawerUsername);

    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, "navigation_drawer_open", "navigation_drawer_close") {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                // Do whatever you want here
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                final String usernameID = sharedPreferences.getString("name", "User");
                tvDrawerUsername.setText(usernameID);
            }
        };
    drawer.addDrawerListener(toggle);
    toggle.syncState();
    setSupportActionBar(toolbar);
}