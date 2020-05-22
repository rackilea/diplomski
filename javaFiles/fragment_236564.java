public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{

    public NavigationView navigationView;
    public DrawerLayout drawer;
    public RelativeLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        content = (RelativeLayout) findViewById(R.id.content);

        navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(layoutResID, null);
        //  var x = layout.LayoutParameters;
        content.addView(layout);
    }


    public void OpenDrawer()
    {
        drawer.openDrawer(Gravity.START,true);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navdrawer_item_first:
                Toast.makeText(this, "first item clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navdrawer_item_second:
                Toast.makeText(this, "second item clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawers();
        return true;
    }
}