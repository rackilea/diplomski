public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private EndDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /* Toolbar */
        getSupportActionBar().setTitle("Nostrils");
        toolbar.setTitleTextColor(0xFFFFFFFF);
        // Back icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initNavigationDrawer();
    }


        drawerLayout = (DrawerLayout)findViewById(R.id.activity_main3);

        drawerToggle = new EndDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close);

        drawerLayout.addDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here.
    int id = item.getItemId();

        // Back icon clicked
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);
        finish();

    return super.onOptionsItemSelected(item);
}


}