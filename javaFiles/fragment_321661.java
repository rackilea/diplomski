public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MenuItem prevItemOfFirstGroup;
    MenuItem prevItemOfSecondGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ... some code

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        prevItemOfFirstGroup=navigationView.getMenu().findItem(R.id.coaching);
        prevItemOfFirstGroup.setChecked(true);
        prevItemOfSecondGroup=navigationView.getMenu().findItem(R.id.new_registrations);
        prevItemOfSecondGroup.setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int groupId = item.getGroupId();
        if (groupId == R.id.first_group) {
            if (prevItemOfFirstGroup != null) {
                prevItemOfFirstGroup.setChecked(false);
            }
            prevItemOfFirstGroup = item;
        } else if (groupId == R.id.second_group) {
            if (prevItemOfSecondGroup != null) {
                prevItemOfSecondGroup.setChecked(false);
            }
            prevItemOfSecondGroup = item;
        }
        item.setChecked(true);

        // Handle navigation view item clicks here.
        int id = item.getItemId();
        // ... some code

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false; // IMPORTANT! NOT TRUE!
    }
}