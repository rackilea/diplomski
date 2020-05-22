}
@Override
public void setContentView(int layoutResID)
{
    /**
     * This is going to be our actual root layout.
     */
    fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
    /**
     * {@link FrameLayout} to inflate the child's view. We could also use a {@link android.view.ViewStub}
     */
    FrameLayout activityContainer = (FrameLayout) fullLayout.findViewById(R.id.activity_content);
    getLayoutInflater().inflate(layoutResID, activityContainer, true);

    /**
     * Note that we don't pass the child's layoutId to the parent,
     * instead we pass it our inflated layout.
     */
    super.setContentView(fullLayout);

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    navigationView = (NavigationView) findViewById(R.id.navigationView);

    if (useToolbar())
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean customBackground = sharedpreferences.getBoolean("customBackground",false);
        if(customBackground==true){

            toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.altbuttonFocused)));
        }
        setSupportActionBar(toolbar);
    }
    else
    {
        toolbar.setVisibility(View.GONE);
    }

    setUpNavView();
}

/**
 * Helper method that can be used by child classes to
 * specify that they don't want a {@link Toolbar}
 * @return true
 */
protected boolean useToolbar()
{
    return true;
}

protected void setUpNavView()
{
    navigationView.setNavigationItemSelectedListener(this);

    if( useDrawerToggle()) { // use the hamburger menu
        drawerToggle = new ActionBarDrawerToggle(this, fullLayout, toolbar,
                R.string.nav_drawer_opened,
                R.string.nav_drawer_closed);

        fullLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    } else if(useToolbar() && getSupportActionBar() != null) {
        // Use home/back button instead
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}

/**
 * Helper method to allow child classes to opt-out of having the
 * hamburger menu.
 * @return
 */
protected boolean useDrawerToggle()
{
    return true;
}


@Override
public boolean onNavigationItemSelected(MenuItem menuItem) {
    fullLayout.closeDrawer(GravityCompat.START);
    selectedNavItemId = menuItem.getItemId();

    return onOptionsItemSelected(menuItem);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
        if (id ==R.id.nav_settings){
            startActivity(new Intent(this,SettingsActivity.class));
            finish();
        }

        }