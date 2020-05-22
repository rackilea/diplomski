public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_images, R.id.navigation_videos,R.id.navigation_songs,R.id.navigation_notifications)
                .build();
        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.getNavigatorProvider().addNavigator(new StickyFragmentNavigator(this, navHostFragment.getChildFragmentManager(),R.id.nav_host_fragment));
        navController.setGraph(R.navigation.mobile_navigation);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView,navController);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (menuItem.isChecked()) return false;

                switch (id)
                {
                    case R.id.navigation_home :
                        navController.navigate(R.id.action_global_navigation_home);
                        break;
                    case R.id.navigation_images :
                        navController.navigate(R.id.action_global_navigation_images);
                        break;
                    case R.id.navigation_videos :
                        navController.navigate(R.id.action_global_navigation_videos);
                        break;
                    case R.id.navigation_songs :
                        navController.navigate(R.id.action_global_navigation_songs);
                        break;
                    case R.id.navigation_notifications :
                        navController.navigate(R.id.action_global_navigation_notifications);
                        break;
                }
                return true;

            }
        });

    }

}