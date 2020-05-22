@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sms_inbox);
    smsListView = (ListView) findViewById(R.id.SmsList);
    arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, smsMessagesList);
    smsListView.setAdapter(arrayAdapter);
    smsListView.setOnItemClickListener(this);
if(ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_SMS") == PackageManager.PERMISSION_GRANTED) {

    ContentResolver cr = getContentResolver();
    Cursor cursor = cr.query(Uri.parse("content://sms/inbox"), null, null,
            null, null);

    int indexBody = cursor.getColumnIndex("body");
    int indexAddr = cursor.getColumnIndex("address");

    if (indexBody < 0 || !cursor.moveToFirst()) return;
    arrayAdapter.clear();
    do {
        String str = "SMS From: " + cursor.getString(indexAddr) +
                "\n" + cursor.getString(indexBody) + "\n";
        arrayAdapter.add(str);
    } while (cursor.moveToNext());
}

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();
    toggle.setDrawerIndicatorEnabled(false);

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);


}