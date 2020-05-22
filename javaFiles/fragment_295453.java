protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowItem = new AppList();
        final ListView userInstalledApps = (ListView)findViewById(R.id.appListView);

        List<AppList> installedApps = getInstalledApps();
        CustomAppAdapter installedAppAdapter = new CustomAppAdapter(MainActivity.this, installedApps);
        userInstalledApps.setAdapter(installedAppAdapter);

        userInstalledApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView appName = (TextView)adapterView.findViewById(R.id.list_app_name);
                Toast.makeText(getApplicationContext(),
                        "Clicked "+ installedApps.get(i).getName(),Toast.LENGTH_LONG).show();

            }
        });
    }