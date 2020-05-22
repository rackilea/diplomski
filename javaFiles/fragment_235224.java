...

public com.companyname.appname.TabStrip mTabStrip = null; /* global variable */

...

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);

        final String toolbarColour = "#868F98";

        mTabStrip = findViewById(R.id.my_tabs);
        Toolbar customToolbar = findViewById(R.id.my_toolbar);
        setActionBar(customToolbar);
...