public class MainActivity extends AppCompatActivity {
    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = mBottomNav.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = mBottomNav.getMenu().getItem(0);
        }

        selectFragment(selectedItem);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStackImmediate();
        } else  {
            super.onBackPressed();
        }
    }

    private void selectFragment(MenuItem item) {

        Fragment frag = null;
        item.setCheckable(true);
        switch (item.getItemId()) {
            case R.id.menu_home:

                TabFragmentOne fragmentone = new TabFragmentOne();
                FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragmentone);
                ft.addToBackStack(null);
                ft.commit();

                break;
            case R.id.menu_notifications:


                TabFragmentThree fragmentone_Three = new TabFragmentThree();
                FragmentTransaction ft_three =  getSupportFragmentManager().beginTransaction();
                ft_three.replace(R.id.container, fragmentone_Three);
                ft_three.addToBackStack(null);
                ft_three.commit();

                break;
            case R.id.menu_search:


                TabFragmentTwo tabFragmentTwo = new TabFragmentTwo();
                FragmentTransaction ft_two =  getSupportFragmentManager().beginTransaction();
                ft_two.replace(R.id.container,tabFragmentTwo);
                ft_two.addToBackStack(null);
                ft_two.commit();

                break;
        }

        // update selected item
        mSelectedItem = item.getItemId();

        updateToolbarText(item.getTitle());

        if (frag != null) {
            TabFragmentOne fragmentone = new TabFragmentOne();
            FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragmentone);
            ft.commit();
        }
    }

    private void updateToolbarText(CharSequence text) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(text);
        }
    }
}