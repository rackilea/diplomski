@Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_listview);

        mTitle = "Androi Reboot";
        getActionBar().setTitle(mTitle);

        // Getting reference to the DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerList = (ListView) findViewById(R.id.drawer_list);

        // Getting reference to the ActionBarDrawerToggle
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                        R.drawable.ic_drawer, R.string.drawer_open,
                        R.string.drawer_close) {

                /** Called when drawer is closed */
                public void onDrawerClosed(View view) {
                        getActionBar().setTitle(mTitle);
                        invalidateOptionsMenu();

                }

                /** Called when a drawer is opened */
                public void onDrawerOpened(View drawerView) {
                        getActionBar().setTitle("Androi Reboot");
                        invalidateOptionsMenu();
                }

        };



        // Setting DrawerToggle on DrawerLayout
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // Creating an ArrayAdapter to add items to the listview mDrawerList
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
                        R.layout.arraylist, getResources().getStringArray(R.array.menus));

        // Setting the adapter on mDrawerList
        mDrawerList.setAdapter(adapter);

        // Enabling Home button
        getActionBar().setHomeButtonEnabled(true);

        // Enabling Up navigation
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Setting item click listener for the listview mDrawerList
        mDrawerList.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {

                        fireFragment(position)
                        // Closing the drawer
                        mDrawerLayout.closeDrawer(mDrawerList);

                }
        });

        fireFragment(0);
}

private void fireFragment(int position){
     // Getting an array of rivers
    String[] menuItems = getResources().getStringArray(R.array.menus);

    // Currently selected river
    mTitle = menuItems[position];

    // Creating a fragment object
    MainActivity rFragment = new MainActivity();

    // Passing selected item information to fragment
    Bundle data = new Bundle();
    data.putInt("position", position);
    data.putString("url", getUrl(position));
    rFragment.setArguments(data);


    // Getting reference to the FragmentManager
    FragmentManager fragmentManager = getFragmentManager();

    // Creating a fragment transaction
    FragmentTransaction ft = fragmentManager.beginTransaction();

    // Adding a fragment to the fragment transaction
    ft.replace(R.id.content_frame, rFragment);

    // Committing the transaction
    ft.commit();
}