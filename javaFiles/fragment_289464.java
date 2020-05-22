@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

myViewPager = (ViewPager) findViewById(R.id.myViewPager);

//somehow fill the adapter
                    MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), getApplicationContext()); //=== required as per the MyAdapter class

                    //set the adapter
                    myViewPager.setAdapter(myAdapter);

                    // display first fragment
                    myViewPager.setCurrentItem(0);