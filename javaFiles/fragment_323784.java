// Inflate your custom layout
    final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(
            R.layout.action_bar,
            null);

    // Set up your ActionBar
    final ActionBar actionBar = getActionBar();
    actionBar.setDisplayShowHomeEnabled(false);
    actionBar.setDisplayShowTitleEnabled(false);
    actionBar.setDisplayShowCustomEnabled(true);
    actionBar.setCustomView(actionBarLayout);

    // You customization
    final int actionBarColor = getResources().getColor(R.color.action_bar);
    actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));

    final Button actionBarTitle = (Button) findViewById(R.id.action_bar_title);
    actionBarTitle.setText("Index(2)");

    final Button actionBarSent = (Button) findViewById(R.id.action_bar_sent);
    actionBarSent.setText("Sent");

    final Button actionBarStaff = (Button) findViewById(R.id.action_bar_staff);
    actionBarStaff.setText("Staff");

    final Button actionBarLocations = (Button) findViewById(R.id.action_bar_locations);
    actionBarLocations.setText("HIPPA Locations");