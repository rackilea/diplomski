public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // tabs        
        firstButton = (Button) findViewById(R.id.firstButton);
        secondButton = (Button) findViewById(R.id.secondButton);        
        thirdButton = (Button) findViewById(R.id.thirdButton);
        forthButton = (Button) findViewById(R.id.forthButton);

        Resources res = getResources(); // Resource object to get Drawables
        final TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        intent = new Intent().setClass(this, FirstGroupActivity.class);
        spec = tabHost.newTabSpec("first").setIndicator("First").setContent(intent);
        tabHost.addTab(spec);
        intent = new Intent().setClass(this, SecondGroupActivity.class);
        spec = tabHost.newTabSpec("second").setIndicator("Second").setContent(intent);
        tabHost.addTab(spec);   

        intent = new Intent().setClass(this, ThirdGroupActivity.class);
        spec = tabHost.newTabSpec("third").setIndicator("Third").setContent(intent);
        tabHost.addTab(spec);


        intent = new Intent().setClass(this, ForthActivity.class);
        spec = tabHost.newTabSpec("forth").setIndicator("Forth").setContent(intent);
        tabHost.addTab(spec);


        tabHost.setCurrentTab(0);

        firstButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v)
            {
                tabHost.setCurrentTab(0);
                firstButton.setBackgroundResource(R.drawable.btn_first_on);
                secondButton.setBackgroundResource(R.drawable.btn_second_off);              
                thirdButton.setBackgroundResource(R.drawable.btn_third_off);
                forthButton.setBackgroundResource(R.drawable.btn_forth_off);            
            }

        });


        secondButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v)
            {
                tabHost.setCurrentTab(1);
                firstButton.setBackgroundResource(R.drawable.btn_first_off);
                secondButton.setBackgroundResource(R.drawable.btn_second_on);                       
                thirdButton.setBackgroundResource(R.drawable.btn_third_off);                        
                forthButton.setBackgroundResource(R.drawable.btn_forth_off);

            }

        });


        thirdButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v)
            {
                tabHost.setCurrentTab(3);
                firstButton.setBackgroundResource(R.drawable.btn_first_off);
                secondButton.setBackgroundResource(R.drawable.btn_second_off);              
                thirdButton.setBackgroundResource(R.drawable.btn_third_on);
                forthButton.setBackgroundResource(R.drawable.btn_forth_off);

            }

        });


        forthButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v)
            {
                tabHost.setCurrentTab(4);
                firstButton.setBackgroundResource(R.drawable.btn_first_off);
                secondButton.setBackgroundResource(R.drawable.btn_second_off);              
                thirdButton.setBackgroundResource(R.drawable.btn_third_off);
                forthButton.setBackgroundResource(R.drawable.btn_forth_on);

            }

        });
    }